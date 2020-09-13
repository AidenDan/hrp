package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.JobLevelService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 14:03:32
 */
@Component
public class JobLevelHystrix implements FallbackFactory<JobLevelService> {
    @Override
    public JobLevelService create(Throwable throwable) {
        return null;
    }
}
