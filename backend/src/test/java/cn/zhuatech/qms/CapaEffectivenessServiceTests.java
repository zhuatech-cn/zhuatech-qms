/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.qms;

import cn.zhuatech.qms.service.CapaEffectivenessService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapaEffectivenessServiceTests {
    private final CapaEffectivenessService service = new CapaEffectivenessService();

    @Test
    void closesEffectiveCapaAfterSustainedReduction() {
        var result = service.review(new CapaEffectivenessService.Request(
            "CAPA-2026-001", .08, .02, .60, 120, 0, 0));

        assertEquals(.75, result.actualReductionRate());
        assertEquals("EFFECTIVE", result.decision());
    }

    @Test
    void reopensCapaWhenDefectRecurs() {
        var result = service.review(new CapaEffectivenessService.Request(
            "CAPA-2026-002", .05, .04, .50, 80, 2, 0));

        assertEquals("REOPEN", result.decision());
    }
}
