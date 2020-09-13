package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.RoleService;
import com.hr.model.Role;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:32:36
 */
@Component
public class RoleHystrix implements FallbackFactory<RoleService> {
    @Override
    public RoleService create(Throwable throwable) {
        return new RoleService() {
            @Override
            public List<Role> getAllRoles() {
                return null;
            }

            @Override
            public Integer addRole(Role role) {
                return null;
            }

            @Override
            public Integer deleteRoleById(Integer rid) {
                return null;
            }
        };
    }
}
