/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.controller;

import cn.zhuatech.qms.common.ApiResponse;
import cn.zhuatech.qms.service.SamplingPlanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/qms")
public class QualityPlanningController {
    private final SamplingPlanService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public QualityPlanningController(SamplingPlanService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/sampling-plan")
    public ApiResponse<SamplingPlanService.Result> recommend(@Valid @RequestBody SamplingPlanService.Request request) {
        return ApiResponse.ok(service.recommend(request));
    }
}
