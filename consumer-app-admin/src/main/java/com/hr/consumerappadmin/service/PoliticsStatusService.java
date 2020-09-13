package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.PoliticsStatusHystrix;
import com.hr.model.Politicsstatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:19:42
 */
@FeignClient(value = "service-app-politics-status", fallbackFactory = PoliticsStatusHystrix.class)
public interface PoliticsStatusService {

    /**
     * getAllPoliticsstatus
     *
     * @return List<Politicsstatus>
     */
    @GetMapping(value = "/")
    public List<Politicsstatus> getAllPoliticsstatus();
}
