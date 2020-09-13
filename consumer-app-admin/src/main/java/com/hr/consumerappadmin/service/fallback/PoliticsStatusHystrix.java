package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.PoliticsStatusService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:21:29
 */
@Component
public class PoliticsStatusHystrix implements FallbackFactory<PoliticsStatusService> {
    @Override
    public PoliticsStatusService create(Throwable throwable) {
        return null;
    }
}
