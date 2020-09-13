package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.NationHystrix;
import com.hr.model.Nation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:16:03
 */
@FeignClient(value = "service-app-nation", fallbackFactory = NationHystrix.class)
public interface NationService {

    /**
     * getAllNations
     *
     * @return List<Nation>
     */
    @GetMapping("/")
    public List<Nation> getAllNations();
}
