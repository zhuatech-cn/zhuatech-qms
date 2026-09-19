/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.controller;

import cn.zhuatech.qms.common.ApiResponse;
import cn.zhuatech.qms.service.CapaEffectivenessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/qms/insights")
public class CapaEffectivenessController {
    private final CapaEffectivenessService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CapaEffectivenessController(CapaEffectivenessService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/capa-effectiveness")
    public ApiResponse<CapaEffectivenessService.Result> review(
        @Valid @RequestBody CapaEffectivenessService.Request request) {
        return ApiResponse.ok(service.review(request));
    }
}
