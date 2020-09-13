package com.hr.serviceappemployee.controller;

import com.hr.model.Role;
import com.hr.serviceappemployee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:26:41
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    RoleService roleService;

    /**
     * getAllRoles
     *
     * @return List<Role>
     */
    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    /**
     * addRole
     *
     * @param role role
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    /**
     * deleteRoleById
     *
     * @param rid rid
     * @return Integer
     */
    @DeleteMapping(value = "/{rid}")
    public Integer deleteRoleById(@PathVariable Integer rid){
        return roleService.deleteRoleById(rid);
    }
}
