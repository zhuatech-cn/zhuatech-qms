/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.repository;
import cn.zhuatech.qms.model.InspectionLot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface InspectionLotRepository extends JpaRepository<InspectionLot,Long>{
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    List<InspectionLot> findAllByOrderByPlannedDateDesc(); /**
                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                            */
long countByStatus(String status); /**
                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                               */
long countByResult(String result);
}
