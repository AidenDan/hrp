package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.SalaryHystrix;
import com.hr.model.Salary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-11 21:54:38
 */
@FeignClient(value = "service-app-salary", fallbackFactory = SalaryHystrix.class)
public interface SalaryService {

    /**
     * getAllSalaries
     *
     * @return List<Salary>
     */
    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    public List<Salary> getAllSalaries();

    /**
     * addSalary
     *
     * @param salary salary
     * @return Integer
     */
    @PostMapping(value = "/", produces = "application/json;charset=UTF-8")
    public Integer addSalary(@RequestBody Salary salary);

    /**
     * deleteSalaryById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public Integer deleteSalaryById(@PathVariable("id") Integer id);

    /**
     * updateSalaryById
     *
     * @param salary salary
     * @return Integer
     */
    @PutMapping(value = "/", produces = "application/json;charset=UTF-8")
    public Integer updateSalaryById(@RequestBody Salary salary);
}
