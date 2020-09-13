package com.hr.serviceappemployee.controller;

import com.hr.model.Department;
import com.hr.serviceappemployee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 17:26:22
 */
@CrossOrigin
@RestController
public class MainController {
    @Autowired
    DepartmentService departmentService;
    /**
     * getAllDepartments
     *
     * @return List<Department>
     */
    @GetMapping(value = "/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    };

    /**
     * addDep
     *
     * @param  dep dep
     */
    @PostMapping(value = "/")
    public void addDep(@RequestBody Department dep) {
        departmentService.addDep(dep);
    }

    /**
     * deleteDepById
     *
     * @param dep dep
     */
    @DeleteMapping(value = "/")
    public void deleteDepById(@RequestBody Department dep){
        departmentService.deleteDepById(dep);
    }

    /**
     * getAllDepartmentsWithOutChildren
     *
     * @return List<Department>
     */
    @GetMapping(value = "/getAllDepartmentsWithOutChildren")
    public List<Department> getAllDepartmentsWithOutChildren(){
        return departmentService.getAllDepartmentsWithOutChildren();
    }
}
