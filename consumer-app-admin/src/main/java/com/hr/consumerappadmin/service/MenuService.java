package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.MenuHystrix;
import com.hr.model.Hr;
import com.hr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:07:06
 */
@FeignClient(value = "service-app-menu", fallbackFactory = MenuHystrix.class)
public interface MenuService {

    /**
     * getMenusByHrId
     *
     * @return List<Menu>
     */
    @PostMapping(value = "/getMenusByHrId")
    public  List<Menu> getMenusByHrId() ;

    /**
     * getAllMenusWithRole
     *
     * @return List<Menu>
     */
    @PostMapping(value = "/")
    public List<Menu> getAllMenusWithRole();

    /**
     * getAllMenus
     *
     * @return List<Menu>
     */
    @PostMapping(value = "/getAllMenus")
    public List<Menu> getAllMenus();

    /**
     * getMidsByRid
     *
     * @param rid rid
     * @return List<Integer>
     */
    @PostMapping(value = "/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid);

    /**
     * updateMenuRole
     *
     * @param rid rid
     * @param mids mids
     * @return boolean
     */
    @PutMapping(value = "/{rid}")
    public boolean updateMenuRole(@PathVariable Integer rid, @RequestBody Integer[] mids) ;
}
