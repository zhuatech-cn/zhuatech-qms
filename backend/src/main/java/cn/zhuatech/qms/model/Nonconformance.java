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
@Table(name = "qms_nonconformance")
public class Nonconformance extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String ncNo;
    @Column(nullable = false, length = 32) private String lotNo;
    @Column(nullable = false, length = 40) private String defectType;
    @Column(nullable = false, length = 16) private String severity;
    @Column(nullable = false, length = 300) private String description;
    @Column(nullable = false) private int quantity;
    @Column(nullable = false, length = 40) private String owner;
    @Column(nullable = false, length = 24) private String status;
    @Column(nullable = false) private LocalDate dueDate;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Nonconformance() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Nonconformance(String ncNo, String lotNo, String defectType, String severity,
                          String description, int quantity, String owner, String status, LocalDate dueDate) {
        this.ncNo=ncNo; this.lotNo=lotNo; this.defectType=defectType; this.severity=severity;
        this.description=description; this.quantity=quantity; this.owner=owner; this.status=status; this.dueDate=dueDate;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void moveTo(String status){this.status=status;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getNcNo(){return ncNo;} /**
                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                           */
public String getLotNo(){return lotNo;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getDefectType(){return defectType;} /**
                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                       */
public String getSeverity(){return severity;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getDescription(){return description;} /**
                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                         */
public int getQuantity(){return quantity;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOwner(){return owner;} /**
                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                             */
public String getStatus(){return status;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getDueDate(){return dueDate;}
}
