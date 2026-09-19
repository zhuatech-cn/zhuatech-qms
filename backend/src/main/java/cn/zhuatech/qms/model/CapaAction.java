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
@Table(name = "qms_capa_action")
public class CapaAction extends BaseEntity {
    @Column(nullable=false, unique=true, length=32) private String actionNo;
    @Column(nullable=false, length=32) private String ncNo;
    @Column(nullable=false, length=120) private String title;
    @Column(nullable=false, length=40) private String owner;
    @Column(nullable=false) private LocalDate dueDate;
    @Column(nullable=false) private int progress;
    @Column(nullable=false, length=24) private String status;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected CapaAction() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CapaAction(String actionNo, String ncNo, String title, String owner,
                      LocalDate dueDate, int progress, String status) {
        this.actionNo=actionNo; this.ncNo=ncNo; this.title=title; this.owner=owner;
        this.dueDate=dueDate; this.progress=progress; this.status=status;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void updateProgress(int progress){this.progress=Math.max(0,Math.min(progress,100));this.status=this.progress>=100?"待验证":"执行中";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getActionNo(){return actionNo;} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getNcNo(){return ncNo;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getTitle(){return title;} /**
                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                             */
public String getOwner(){return owner;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDate getDueDate(){return dueDate;} /**
                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                    */
public int getProgress(){return progress;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getStatus(){return status;}
}
