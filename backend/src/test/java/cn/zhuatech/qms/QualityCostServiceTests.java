/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms;

import cn.zhuatech.qms.service.QualityCostService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class QualityCostServiceTests {
    private final QualityCostService service = new QualityCostService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void highlightsCriticalPoorQualityCost() {
        var result = service.analyze(new QualityCostService.Request("2026-07", new BigDecimal("1000000"),
            new BigDecimal("20000"), new BigDecimal("25000"), new BigDecimal("30000"), new BigDecimal("40000")));
        assertThat(result.status()).isEqualTo("CRITICAL");
        assertThat(result.copqRate()).isEqualByComparingTo("0.0700");
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void recognizesControlledQualityCost() {
        var result = service.analyze(new QualityCostService.Request("2026-08", new BigDecimal("2000000"),
            new BigDecimal("30000"), new BigDecimal("30000"), new BigDecimal("10000"), new BigDecimal("8000")));
        assertThat(result.status()).isEqualTo("CONTROLLED");
        assertThat(result.totalQualityCost()).isEqualByComparingTo("78000.00");
    }
}
