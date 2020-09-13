package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.DepartmentHystrix;
import com.hr.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 13:23:25
 */
@FeignClient(value = "service-app-department", fallbackFactory = DepartmentHystrix.class)
public interface DepartmentService {

    /**
     * getAllDepartments
     *
     * @return List<Department>
     */
    @GetMapping(value = "/")
    public List<Department> getAllDepartments();

    /**
     * addDep
     *
     * @param  dep dep
     */
    @PostMapping(value = "/")
    public void addDep(@RequestBody Department dep) ;

    /**
     * deleteDepById
     *
     * @param dep dep
     */
    @DeleteMapping(value = "/")
    public void deleteDepById(@RequestBody Department dep);

    /**
     * getAllDepartmentsWithOutChildren
     *
     * @return List<Department>
     */
    @GetMapping(value = "/getAllDepartmentsWithOutChildren")
    public List<Department> getAllDepartmentsWithOutChildren();
}
