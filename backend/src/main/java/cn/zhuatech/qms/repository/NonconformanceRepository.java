/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.qms.repository;
import cn.zhuatech.qms.model.Nonconformance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface NonconformanceRepository extends JpaRepository<Nonconformance,Long>{
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    List<Nonconformance> findAllByOrderByDueDateAsc(); /**
                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                        */
long countByStatusNot(String status);
}
