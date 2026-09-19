/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.dto;

import cn.zhuatech.qms.model.CapaAction;
import cn.zhuatech.qms.model.InspectionLot;
import cn.zhuatech.qms.model.Nonconformance;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public final class QmsDto {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    private QmsDto() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Dashboard(long pendingInspection,long failedLots,long openNc,long overdueCapa,
                            double firstPassYield,double supplierPassRate,
                            List<InspectionView> urgentLots,List<NcView> qualityRisks){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record InspectionView(Long id,String lotNo,String materialCode,String materialName,String sourceType,
                                 String sourceRef,String supplierName,int batchQty,int sampleQty,LocalDate plannedDate,
                                 String inspector,String status,String result,int defectQty,String remarks){
        /**
         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
         */
        public static InspectionView from(InspectionLot l){return new InspectionView(l.getId(),l.getLotNo(),l.getMaterialCode(),l.getMaterialName(),l.getSourceType(),l.getSourceRef(),l.getSupplierName(),l.getBatchQty(),l.getSampleQty(),l.getPlannedDate(),l.getInspector(),l.getStatus(),l.getResult(),l.getDefectQty(),l.getRemarks());}
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record NcView(Long id,String ncNo,String lotNo,String defectType,String severity,String description,
                         int quantity,String owner,String status,LocalDate dueDate){
        /**
         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
         */
        public static NcView from(Nonconformance n){return new NcView(n.getId(),n.getNcNo(),n.getLotNo(),n.getDefectType(),n.getSeverity(),n.getDescription(),n.getQuantity(),n.getOwner(),n.getStatus(),n.getDueDate());}
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record CapaView(Long id,String actionNo,String ncNo,String title,String owner,LocalDate dueDate,int progress,String status){
        /**
         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
         */
        public static CapaView from(CapaAction a){return new CapaView(a.getId(),a.getActionNo(),a.getNcNo(),a.getTitle(),a.getOwner(),a.getDueDate(),a.getProgress(),a.getStatus());}
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record CreateLotRequest(@NotBlank String materialCode,@NotBlank String materialName,@NotBlank String sourceType,
                                   @NotBlank String sourceRef,String supplierName,@Positive int batchQty,@Positive int sampleQty,
                                   @NotNull LocalDate plannedDate,@NotBlank String inspector){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record CompleteInspectionRequest(@NotBlank String result,@Min(0) int defectQty,String remarks){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record CreateNcRequest(@NotBlank String lotNo,@NotBlank String defectType,@NotBlank String severity,
                                  @NotBlank String description,@Positive int quantity,@NotBlank String owner,
                                  @NotNull LocalDate dueDate){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record UpdateProgressRequest(@Min(0) @Max(100) int progress){}
}
