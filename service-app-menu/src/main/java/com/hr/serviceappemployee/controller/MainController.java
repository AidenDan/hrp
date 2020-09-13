package com.hr.serviceappemployee.controller;

import com.hr.model.Menu;
import com.hr.serviceappemployee.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:11:05
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    MenuService menuService;

    /**
     * getMenusByHrId
     *
     * @return List<Menu>
     */
    @PostMapping(value = "/getMenusByHrId")
    public List<Menu> getMenusByHrId() {
        return menuService.getMenusByHrId();
    }

    /**
     * getAllMenusWithRole
     *
     * @return List<Menu>
     */
    @PostMapping(value = "/")
    public List<Menu> getAllMenusWithRole(){
        return menuService.getAllMenusWithRole();
    }

    /**
     * getAllMenus
     *
     * @return List<Menu>
     */
    @PostMapping(value = "/getAllMenus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    /**
     * getMidsByRid
     *
     * @param rid rid
     * @return List<Integer>
     */
    @PostMapping(value = "/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }

    /**
     * updateMenuRole
     *
     * @param rid rid
     * @param mids mids
     * @return boolean
     */
    @PutMapping(value = "/{rid}")
    public boolean updateMenuRole(@PathVariable Integer rid, @RequestBody Integer[] mids) {
        return menuService.updateMenuRole(rid, mids);
    }
}
