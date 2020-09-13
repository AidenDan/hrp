package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.SalaryService;
import com.hr.model.Salary;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-11 21:58:16
 */
@Component
public class SalaryHystrix implements FallbackFactory<SalaryService> {

    @Override
    public SalaryService create(Throwable throwable) {
        return new SalaryService() {
            @Override
            public List<Salary> getAllSalaries() {
                return null;
            }

            @Override
            public Integer addSalary(Salary salary) {
                return null;
            }

            @Override
            public Integer deleteSalaryById(Integer id) {
                return null;
            }

            @Override
            public Integer updateSalaryById(Salary salary) {
                return null;
            }
        };
    }
}
