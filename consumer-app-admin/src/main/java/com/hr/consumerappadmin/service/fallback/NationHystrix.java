package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.NationService;
import com.hr.model.Nation;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:16:54
 */
@Component
public class NationHystrix implements FallbackFactory<NationService> {
    @Override
    public NationService create(Throwable throwable) {
        return new NationService() {
            @Override
            public List<Nation> getAllNations() {
                return null;
            }
        };
    }
}
