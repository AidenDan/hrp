package com.hr.serviceappjoblevel.controller;

import com.hr.model.JobLevel;
import com.hr.serviceappjoblevel.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 17:55:52
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    JobLevelService jobLevelService;

    /**
     * getAllJobLevels
     *
     * @return List<JobLevel>
     */
    @GetMapping(value = "/")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    /**
     * addJobLevel
     *
     * @param jobLevel jobLevel
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addJobLevel(@RequestBody JobLevel jobLevel) {
        return jobLevelService.addJobLevel(jobLevel);
    }

    /**
     * updateJobLevelById
     *
     * @param jobLevel jobLevel
     * @return Integer
     */
    @PutMapping(value = "/")
    public Integer updateJobLevelById(@RequestBody JobLevel jobLevel){
        return jobLevelService.updateJobLevelById(jobLevel);
    }

    /**
     * deleteJobLevelById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteJobLevelById(@PathVariable("id") Integer id){
        return jobLevelService.deleteJobLevelById(id);
    }

    /**
     * deleteJobLevelsByIds
     *
     * @param ids ids
     * @return Integer
     */
    @DeleteMapping(value = "/")
    public Integer deleteJobLevelsByIds(@RequestBody Integer[] ids){
        return jobLevelService.deleteJobLevelsByIds(ids);
    }
}
