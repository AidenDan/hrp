package com.hr.serviceappemployee.controller;

import com.hr.model.Employee;
import com.hr.model.RespPageBean;
import com.hr.serviceappemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:34:22
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    EmployeeService employeeService;

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
            @RequestBody Map<String, Object> map) {
        Employee employee = (Employee)map.get("employee");
        Date[] beginDateScope = (Date[])map.get("beginDateScope");
        return employeeService.getEmployeeByPage(page, size, employee, beginDateScope);
    }

    /**
     * addEmp
     *
     * @param employee employee
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addEmp(@RequestBody Employee employee) {
        return employeeService.addEmp(employee);
    }

    /**
     * maxWorkID
     *
     * @return Integer
     */
    @GetMapping("/maxWorkID")
    public Integer maxWorkID(){
        return employeeService.maxWorkID();
    }

    /**
     * deleteEmpByEid
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping("/{id}")
    public Integer deleteEmpByEid(@PathVariable("id") Integer id){
        return employeeService.deleteEmpByEid(id);
    }

    /**
     * updateEmp
     *
     * @param employee employee
     * @return Integer
     */
    @PutMapping("/")
    public Integer updateEmp(@RequestBody Employee employee){
        return employeeService.updateEmp(employee);
    }

    /**
     * addEmps
     *
     * @param list list
     * @return Integer
     */
    @PostMapping(value = "/addEmps")
    public Integer addEmps(@RequestBody List<Employee> list){
        return employeeService.addEmps(list);
    }

    /**
     * getEmployeeByPageWithSalary
     *
     * @param page page
     * @param size size
     * @return RespPageBean
     */
    @GetMapping(value = "/{page}/{size}")
    public RespPageBean getEmployeeByPageWithSalary(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    /**
     * updateEmployeeSalaryById
     *
     * @param eid eid
     * @param sid sid
     * @return Integer
     */
    @PutMapping(value = "/{eid}/{sid}")
    public Integer updateEmployeeSalaryById(@PathVariable("eid") Integer eid, @PathVariable("sid") Integer sid) {
        return employeeService.updateEmployeeSalaryById(eid, sid);
    }

    /**
     * getEmployeeById
     *
     * @param empId empId
     * @return Employee
     */
    @GetMapping(value = "/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Integer empId) {
        return employeeService.getEmployeeById(empId);
    }
}
