package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.EmployeeService;
import com.hr.model.Employee;
import com.hr.model.RespPageBean;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 13:21:12
 */
@Component
public class EmployeeHystrix implements FallbackFactory<EmployeeService> {
    @Override
    public EmployeeService create(Throwable throwable) {
        return new EmployeeService() {
            /**
             * getEmployeeByPage
             *
             * @param page page
             * @param size size
             * @param map  map
             * @return RespPageBean
             */
            @Override
            public RespPageBean getEmployeeByPage(Integer page, Integer size, Map<String, Object> map) {
                return null;
            }

            @Override
            public Integer addEmp(Employee employee) {
                return null;
            }

            @Override
            public Integer maxWorkID() {
                return null;
            }

            @Override
            public Integer deleteEmpByEid(Integer id) {
                return null;
            }

            @Override
            public Integer updateEmp(Employee employee) {
                return null;
            }

            @Override
            public Integer addEmps(List<Employee> list) {
                return null;
            }

            @Override
            public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
                return null;
            }

            @Override
            public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
                return null;
            }

            @Override
            public Employee getEmployeeById(Integer empId) {
                return null;
            }
        };
    }
}
