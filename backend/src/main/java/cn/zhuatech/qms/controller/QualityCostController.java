/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.controller;

import cn.zhuatech.qms.common.ApiResponse;
import cn.zhuatech.qms.service.QualityCostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qms/insights")
public class QualityCostController {
    private final QualityCostService service;
    public QualityCostController(QualityCostService service) { this.service = service; }

    @PostMapping("/quality-cost")
    public ApiResponse<QualityCostService.Result> analyze(@Valid @RequestBody QualityCostService.Request request) {
        return ApiResponse.ok(service.analyze(request));
    }
}
