package com.hr.serviceappemployee.controller;

import com.hr.model.Salary;
import com.hr.serviceappemployee.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:30:05
 */
@RestController("salaryMainController")
@CrossOrigin
public class MainController {
    @Autowired
    SalaryService salaryService;

    /**
     * getAllSalaries
     *
     * @return List<Salary>
     */
    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    public List<Salary> getAllSalaries(){
        return salaryService.getAllSalaries();
    }

    /**
     * addSalary
     *
     * @param salary salary
     * @return Integer
     */
    @PostMapping(value = "/", produces = "application/json;charset=UTF-8")
    public Integer addSalary(@RequestBody Salary salary){
        return salaryService.addSalary(salary);
    }

    /**
     * deleteSalaryById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public Integer deleteSalaryById(@PathVariable("id") Integer id){
        return salaryService.deleteSalaryById(id);
    }

    /**
     * updateSalaryById
     *
     * @param salary salary
     * @return Integer
     */
    @PutMapping(value = "/", produces = "application/json;charset=UTF-8")
    public Integer updateSalaryById(@RequestBody Salary salary){
        return salaryService.updateSalaryById(salary);
    }
}
