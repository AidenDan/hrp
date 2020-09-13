package com.hr.consumerappadmin.config;

import com.hr.mapper.HrMapper;
import com.hr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 20:55:57
 */
@Component("hrServiceConf")
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper  hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }
}
