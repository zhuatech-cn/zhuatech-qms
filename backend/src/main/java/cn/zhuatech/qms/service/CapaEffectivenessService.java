/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.qms.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapaEffectivenessService {
    public Result review(Request request) {
        double reductionRate = round((request.baselineDefectRate() - request.currentDefectRate())
            / request.baselineDefectRate());
        String decision = request.recurrenceCount() >= 2
            || request.currentDefectRate() >= request.baselineDefectRate() ? "REOPEN"
            : reductionRate >= request.targetReductionRate()
                && request.recurrenceCount() == 0 && request.overdueActions() == 0 ? "EFFECTIVE" : "EXTEND";

        List<String> actions = new ArrayList<>();
        if (request.sampleSize() < 30) actions.add("扩大验证样本后再关闭 CAPA");
        if (request.overdueActions() > 0) actions.add("完成逾期纠正措施并重新指定责任人与期限");
        if (request.recurrenceCount() > 0) actions.add("复盘复发批次并验证根因是否识别完整");
        if ("EFFECTIVE".equals(decision)) actions.add("关闭 CAPA 并将控制措施纳入标准作业");
        if (actions.isEmpty()) actions.add("延长观察周期并持续跟踪缺陷率趋势");
        return new Result(request.capaNo(), reductionRate, request.targetReductionRate(),
            decision, actions);
    }

    private double round(double value) {
        return Math.round(value * 10_000D) / 10_000D;
    }

    public record Request(@NotBlank String capaNo, @DecimalMin("0.0001") double baselineDefectRate,
                          @DecimalMin("0") double currentDefectRate,
                          @DecimalMin("0") @DecimalMax("1") double targetReductionRate,
                          @Min(1) int sampleSize, @Min(0) int recurrenceCount,
                          @Min(0) int overdueActions) {}

    public record Result(String capaNo, double actualReductionRate, double targetReductionRate,
                         String decision, List<String> actions) {}
}
