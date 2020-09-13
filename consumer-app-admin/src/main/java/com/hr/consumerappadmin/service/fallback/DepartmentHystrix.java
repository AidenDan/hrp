package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.DepartmentService;
import com.hr.model.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 13:25:28
 */
@Component
public class DepartmentHystrix implements FallbackFactory<DepartmentService> {
    @Override
    public DepartmentService create(Throwable throwable) {
        return new DepartmentService() {
            @Override
            public List<Department> getAllDepartments() {
                return null;
            }

            @Override
            public void addDep(Department dep) {

            }

            @Override
            public void deleteDepById(Department dep) {

            }

            /**
             * getAllDepartmentsWithOutChildren
             *
             * @return List<Department>
             */
            @Override
            public List<Department> getAllDepartmentsWithOutChildren() {
                return null;
            }
        };
    }
}
