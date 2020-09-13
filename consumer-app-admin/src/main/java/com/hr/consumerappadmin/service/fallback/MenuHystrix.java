package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.MenuService;
import com.hr.model.Menu;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:07:49
 */
@Component
public class MenuHystrix implements FallbackFactory<MenuService> {
    @Override
    public MenuService create(Throwable throwable) {
        return new MenuService() {
            @Override
            public List<Menu> getMenusByHrId() {
                return null;
            }

            @Override
            public List<Menu> getAllMenusWithRole() {
                return null;
            }

            @Override
            public List<Menu> getAllMenus() {
                return null;
            }

            @Override
            public List<Integer> getMidsByRid(Integer rid) {
                return null;
            }

            @Override
            public boolean updateMenuRole(Integer rid, Integer[] mids) {
                return false;
            }
        };
    }
}
