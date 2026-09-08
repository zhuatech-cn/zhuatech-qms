/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.controller;
import cn.zhuatech.qms.common.ApiResponse;import cn.zhuatech.qms.service.CapaClosureGovernanceService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/enterprise/qms")public class CapaClosureGovernanceController{
 private final CapaClosureGovernanceService service;public CapaClosureGovernanceController(CapaClosureGovernanceService service){this.service=service;}
 @PostMapping("/capa-closure")public ApiResponse<CapaClosureGovernanceService.Assessment> assess(@Valid @RequestBody CapaClosureGovernanceService.Request request){return ApiResponse.ok("CAPA 关闭评估完成",service.assess(request));}
}
