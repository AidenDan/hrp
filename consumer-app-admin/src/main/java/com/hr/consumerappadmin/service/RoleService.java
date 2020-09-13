package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.RoleHystrix;
import com.hr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:31:56
 */
@FeignClient(value = "service-app-role", fallbackFactory = RoleHystrix.class)
public interface RoleService {

    /**
     * getAllRoles
     *
     * @return List<Role>
     */
    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles();

    /**
     * addRole
     *
     * @param role role
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addRole(@RequestBody Role role) ;

    /**
     * deleteRoleById
     *
     * @param rid rid
     * @return Integer
     */
    @DeleteMapping(value = "/{rid}")
    public Integer deleteRoleById(@PathVariable Integer rid);
}
