package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.JobLevelHystrix;
import com.hr.model.JobLevel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 14:02:19
 */
@FeignClient(value = "service-app-job-level", fallbackFactory = JobLevelHystrix.class)
public interface JobLevelService {

    /**
     * getAllJobLevels
     *
     * @return List<JobLevel>
     */
    @GetMapping(value = "/")
    public List<JobLevel> getAllJobLevels();

    /**
     * addJobLevel
     *
     * @param jobLevel jobLevel
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addJobLevel(@RequestBody JobLevel jobLevel) ;

    /**
     * updateJobLevelById
     *
     * @param jobLevel jobLevel
     * @return Integer
     */
    @PutMapping(value = "/")
    public Integer updateJobLevelById(@RequestBody JobLevel jobLevel);

    /**
     * deleteJobLevelById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteJobLevelById(@PathVariable("id") Integer id);

    /**
     * deleteJobLevelsByIds
     *
     * @param ids ids
     * @return Integer
     */
    @DeleteMapping(value = "/")
    public Integer deleteJobLevelsByIds(@RequestBody Integer[] ids);
}
