/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.service;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.assertThat;
class CapaClosureGovernanceServiceTest{
 private final CapaClosureGovernanceService service=new CapaClosureGovernanceService();
 private CapaClosureGovernanceService.Request request(boolean audit,boolean monitor){return new CapaClosureGovernanceService.Request("CAPA-1","owner","qa",30,20,true,true,true,false,true,true,true,true,false,true,false,true,audit,monitor);}
 @Test void closesEffectiveCapa(){assertThat(service.assess(request(true,true)).decision()).isEqualTo(CapaClosureGovernanceService.Decision.CLOSE);}
 @Test void reviewsIncompleteAuditAndMonitoring(){var a=service.assess(request(false,false));assertThat(a.decision()).isEqualTo(CapaClosureGovernanceService.Decision.REVIEW);assertThat(a.actions()).hasSize(2);}
 @Test void reopensRecurringHighRiskCapa(){var r=new CapaClosureGovernanceService.Request("CAPA-2","same","same",2,20,false,false,false,true,false,true,false,false,true,false,true,false,false,false);var a=service.assess(r);assertThat(a.decision()).isEqualTo(CapaClosureGovernanceService.Decision.REOPEN);assertThat(a.riskLevel()).isEqualTo(CapaClosureGovernanceService.RiskLevel.CRITICAL);assertThat(a.blockers()).hasSizeGreaterThanOrEqualTo(10);}
}
