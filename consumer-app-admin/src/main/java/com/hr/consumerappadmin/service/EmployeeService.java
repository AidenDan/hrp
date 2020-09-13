package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.EmployeeHystrix;
import com.hr.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 12:36:27
 */
@FeignClient(value = "service-app-employee", fallbackFactory = EmployeeHystrix.class)
public interface EmployeeService {

    /**
     * getEmployeeByPage
     *
     * @param page page
     * @param size size
     * @param map map
     * @return RespPageBean
     */
    @PostMapping(value = "/{page}/{size}")
    public RespPageBean getEmployeeByPage(
                                          @PathVariable("page") Integer page,
                                          @PathVariable("size") Integer size,
                                          @RequestBody Map<String, Object> map) ;

    /**
     * addEmp
     *
     * @param employee employee
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addEmp(@RequestBody Employee employee) ;

    /**
     * maxWorkID
     *
     * @return Integer
     */
    @GetMapping("/maxWorkID")
    public Integer maxWorkID();

    /**
     * deleteEmpByEid
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping("/{id}")
    public Integer deleteEmpByEid(@PathVariable("id") Integer id);

    /**
     * updateEmp
     *
     * @param employee employee
     * @return Integer
     */
    @PutMapping("/")
    public Integer updateEmp(@RequestBody Employee employee);

    /**
     * addEmps
     *
     * @param list list
     * @return Integer
     */
    @PostMapping(value = "/addEmps")
    public Integer addEmps(@RequestBody List<Employee> list);

    /**
     * getEmployeeByPageWithSalary
     *
     * @param page page
     * @param size size
     * @return RespPageBean
     */
    @GetMapping(value = "/{page}/{size}")
    public RespPageBean getEmployeeByPageWithSalary(@PathVariable("page") Integer page, @PathVariable("size") Integer size) ;

    /**
     * updateEmployeeSalaryById
     *
     * @param eid eid
     * @param sid sid
     * @return Integer
     */
    @PutMapping(value = "/{eid}/{sid}")
    public Integer updateEmployeeSalaryById(@PathVariable("eid") Integer eid, @PathVariable("sid") Integer sid) ;

    /**
     * getEmployeeById
     *
     * @param empId empId
     * @return Employee
     */
    @GetMapping(value = "/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Integer empId) ;
}
