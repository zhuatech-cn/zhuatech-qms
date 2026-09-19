/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "qms_inspection_lot")
public class InspectionLot extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String lotNo;
    @Column(nullable = false, length = 32) private String materialCode;
    @Column(nullable = false, length = 80) private String materialName;
    @Column(nullable = false, length = 24) private String sourceType;
    @Column(nullable = false, length = 40) private String sourceRef;
    @Column(length = 80) private String supplierName;
    @Column(nullable = false) private int batchQty;
    @Column(nullable = false) private int sampleQty;
    @Column(nullable = false) private LocalDate plannedDate;
    @Column(length = 40) private String inspector;
    @Column(nullable = false, length = 24) private String status;
    @Column(length = 24) private String result;
    @Column(nullable = false) private int defectQty;
    @Column(length = 300) private String remarks;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected InspectionLot() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public InspectionLot(String lotNo, String materialCode, String materialName, String sourceType,
                         String sourceRef, String supplierName, int batchQty, int sampleQty,
                         LocalDate plannedDate, String inspector, String status) {
        this.lotNo = lotNo; this.materialCode = materialCode; this.materialName = materialName;
        this.sourceType = sourceType; this.sourceRef = sourceRef; this.supplierName = supplierName;
        this.batchQty = batchQty; this.sampleQty = sampleQty; this.plannedDate = plannedDate;
        this.inspector = inspector; this.status = status;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void complete(String result, int defectQty, String remarks) {
        this.result = result; this.defectQty = defectQty; this.remarks = remarks; this.status = "已完成";
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getLotNo(){return lotNo;} /**
                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                             */
public String getMaterialCode(){return materialCode;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getMaterialName(){return materialName;} /**
                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                           */
public String getSourceType(){return sourceType;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getSourceRef(){return sourceRef;} /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public String getSupplierName(){return supplierName;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getBatchQty(){return batchQty;} /**
                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                */
public int getSampleQty(){return sampleQty;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getPlannedDate(){return plannedDate;} /**
                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                            */
public String getInspector(){return inspector;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getStatus(){return status;} /**
                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                               */
public String getResult(){return result;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getDefectQty(){return defectQty;} /**
                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                  */
public String getRemarks(){return remarks;}
}
