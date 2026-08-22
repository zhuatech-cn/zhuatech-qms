/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class QualityCostService {
    public Result analyze(Request request) {
        BigDecimal conformanceCost = request.preventionCost().add(request.appraisalCost());
        BigDecimal failureCost = request.internalFailureCost().add(request.externalFailureCost());
        BigDecimal total = conformanceCost.add(failureCost).setScale(2, RoundingMode.HALF_UP);
        BigDecimal copqRate = failureCost.divide(request.revenue(), 4, RoundingMode.HALF_UP);
        BigDecimal preventionShare = total.signum() == 0 ? BigDecimal.ZERO
            : request.preventionCost().divide(total, 4, RoundingMode.HALF_UP);
        String status = copqRate.compareTo(new BigDecimal("0.05")) >= 0 ? "CRITICAL"
            : copqRate.compareTo(new BigDecimal("0.02")) >= 0 ? "WARNING" : "CONTROLLED";
        List<String> actions = new ArrayList<>();
        if (request.externalFailureCost().compareTo(request.internalFailureCost()) > 0) actions.add("优先治理客诉、退货和现场质量损失");
        if (preventionShare.compareTo(new BigDecimal("0.15")) < 0) actions.add("提高预防投入并前移关键质量控制点");
        if ("CRITICAL".equals(status)) actions.add("建立质量成本专项并按产品线追踪损失闭环");
        if (actions.isEmpty()) actions.add("维持质量成本结构并按月监控趋势");
        return new Result(request.period(), conformanceCost, failureCost, total, copqRate, preventionShare, status, actions);
    }

    public record Request(@NotBlank String period, @DecimalMin("0.01") BigDecimal revenue,
                          @DecimalMin("0") BigDecimal preventionCost,
                          @DecimalMin("0") BigDecimal appraisalCost,
                          @DecimalMin("0") BigDecimal internalFailureCost,
                          @DecimalMin("0") BigDecimal externalFailureCost) {}
    public record Result(String period, BigDecimal conformanceCost, BigDecimal failureCost,
                         BigDecimal totalQualityCost, BigDecimal copqRate, BigDecimal preventionShare,
                         String status, List<String> actions) {}
}
