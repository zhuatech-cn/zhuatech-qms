/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.controller;
import cn.zhuatech.qms.common.ApiResponse;
import cn.zhuatech.qms.dto.QmsDto.*;
import cn.zhuatech.qms.service.QmsService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/qms")
public class QualityController {
    private final QmsService service; /**
                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                       */
public QualityController(QmsService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.dashboard());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/inspections") public ApiResponse<List<InspectionView>> inspections(){return ApiResponse.ok(service.inspections());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/nonconformances") public ApiResponse<List<NcView>> nonconformances(){return ApiResponse.ok(service.nonconformances());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/capa-actions") public ApiResponse<List<CapaView>> capaActions(){return ApiResponse.ok(service.capaActions());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/inspections") @PreAuthorize("hasAnyRole('ADMIN','QUALITY_ENGINEER')")
    public ApiResponse<InspectionView> createLot(@Valid @RequestBody CreateLotRequest r){return ApiResponse.ok("检验批创建成功",service.createLot(r));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PatchMapping("/inspections/{id}/complete") @PreAuthorize("hasAnyRole('ADMIN','QUALITY_ENGINEER','INSPECTOR')")
    public ApiResponse<InspectionView> complete(@PathVariable Long id,@Valid @RequestBody CompleteInspectionRequest r){return ApiResponse.ok("检验结果已提交",service.completeInspection(id,r));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/nonconformances") @PreAuthorize("hasAnyRole('ADMIN','QUALITY_ENGINEER','INSPECTOR')")
    public ApiResponse<NcView> createNc(@Valid @RequestBody CreateNcRequest r){return ApiResponse.ok("不合格品报告已创建",service.createNonconformance(r));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PatchMapping("/capa-actions/{id}/progress") @PreAuthorize("hasAnyRole('ADMIN','QUALITY_ENGINEER')")
    public ApiResponse<CapaView> updateProgress(@PathVariable Long id,@Valid @RequestBody UpdateProgressRequest r){return ApiResponse.ok("措施进度已更新",service.updateProgress(id,r));}
}
