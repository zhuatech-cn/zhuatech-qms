/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class CapaClosureGovernanceService{
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Assessment assess(Request r){
  List<String> blockers=new ArrayList<>();List<String> actions=new ArrayList<>();
  if(!r.rootCauseValidated())blockers.add("根因尚未通过验证");
  if(!r.correctiveActionsCompleted())blockers.add("纠正措施未全部完成");
  if(!r.effectivenessWindowCompleted())blockers.add("有效性观察窗口尚未结束");
  if(r.effectivenessSampleSize()<r.minimumSampleSize())blockers.add("有效性验证样本量不足");
  if(r.recurrenceDetected())blockers.add("观察期内发现问题复发");
  if(!r.objectiveEvidenceAttached())blockers.add("缺少客观验证证据");
  if(r.procedureChangeRequired()&&!r.documentAndTrainingUpdated())blockers.add("流程文件或培训尚未同步更新");
  if(!r.riskReassessed())blockers.add("关闭前未重新评估残余风险");
  if(r.ownerId().equals(r.qaApproverId()))blockers.add("CAPA 责任人与 QA 关闭审批人必须独立");
  if(!r.linkedRecordsResolved())blockers.add("关联 NCR、审核或客诉记录尚未处置完成");
  if(r.overdue()&&!r.overdueEscalated())blockers.add("逾期 CAPA 未完成管理层升级");
  if(!r.auditTrailComplete())actions.add("补齐状态流转、签名和时间戳审计链");
  if(!r.postClosureMonitoringScheduled())actions.add("创建关闭后趋势监测任务");
  RiskLevel risk=r.residualRiskHigh()||r.recurrenceDetected()?RiskLevel.CRITICAL:r.overdue()?RiskLevel.HIGH:RiskLevel.NORMAL;
  if(r.residualRiskHigh())blockers.add("残余风险仍为高等级，不允许关闭");
  Decision decision=!blockers.isEmpty()?Decision.REOPEN:!actions.isEmpty()?Decision.REVIEW:Decision.CLOSE;
  String route=risk==RiskLevel.CRITICAL?"CAPA负责人→QA经理→管理者代表":risk==RiskLevel.HIGH?"CAPA负责人→QA经理":"CAPA负责人→QA审批人";
  return new Assessment(r.capaNo(),decision,risk,route,List.copyOf(blockers),List.copyOf(actions));
 }
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@NotBlank String capaNo,@NotBlank String ownerId,@NotBlank String qaApproverId,
  @Min(0)int effectivenessSampleSize,@Min(1)int minimumSampleSize,boolean rootCauseValidated,
  boolean correctiveActionsCompleted,boolean effectivenessWindowCompleted,boolean recurrenceDetected,
  boolean objectiveEvidenceAttached,boolean procedureChangeRequired,boolean documentAndTrainingUpdated,
  boolean riskReassessed,boolean residualRiskHigh,boolean linkedRecordsResolved,boolean overdue,
  boolean overdueEscalated,boolean auditTrailComplete,boolean postClosureMonitoringScheduled){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Assessment(String capaNo,Decision decision,RiskLevel riskLevel,String approvalRoute,List<String> blockers,List<String> actions){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public enum Decision{CLOSE,REVIEW,REOPEN}/**
                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                           */
public enum RiskLevel{NORMAL,HIGH,CRITICAL}
}
