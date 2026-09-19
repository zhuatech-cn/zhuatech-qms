/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.deep;import jakarta.persistence.*;import java.time.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_qms_plan",uniqueConstraints=@UniqueConstraint(columnNames="plan_no")) class QualityPlan{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="plan_no")String planNo;String materialCode;String supplierCode;double aql;int acceptanceNumber;String status="DRAFT";@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                            */
protected QualityPlan(){}/**
                                                                                                                                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                     */
QualityPlan(String n,String m,String s,double a,int ac){planNo=n;materialCode=m;supplierCode=s;aql=a;acceptanceNumber=ac;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_qms_inspection",uniqueConstraints=@UniqueConstraint(columnNames="inspection_no")) class InspectionOrder{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="inspection_no")String inspectionNo;Long planId;int lotQty;int sampleQty;int defectQty;String result="PENDING";String status="CREATED";LocalDateTime completedAt;@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                       */
protected InspectionOrder(){}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                    */
InspectionOrder(String n,Long p,int l,int s){inspectionNo=n;planId=p;lotQty=l;sampleQty=s;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_qms_nc",uniqueConstraints=@UniqueConstraint(columnNames="nc_no")) class QualityNonconformance{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="nc_no")String ncNo;Long inspectionId;String severity;String description;String disposition;String status="OPEN";@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                             */
protected QualityNonconformance(){}/**
                                                                                                                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                */
QualityNonconformance(String n,Long i,String s,String d){ncNo=n;inspectionId=i;severity=s;description=d;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_qms_capa",uniqueConstraints=@UniqueConstraint(columnNames="capa_no")) class QualityCapa{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="capa_no")String capaNo;Long ncId;String rootCause;String correctiveAction;String preventiveAction;String evidenceHash;String status="OPEN";@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                  */
protected QualityCapa(){}/**
                                                                                                                                                                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                           */
QualityCapa(String n,Long i,String r,String c,String p){capaNo=n;ncId=i;rootCause=r;correctiveAction=c;preventiveAction=p;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_qms_audit") class QualityAudit{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;String action;String aggregateNo;String detail;LocalDateTime createdAt=LocalDateTime.now();/**
                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                 */
protected QualityAudit(){}/**
                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                           */
QualityAudit(String a,String n,String d){action=a;aggregateNo=n;detail=d;}}
