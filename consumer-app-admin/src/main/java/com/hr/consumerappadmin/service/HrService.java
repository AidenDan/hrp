package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.HrHystrix;
import com.hr.model.Hr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 13:37:15
 */
@FeignClient(value = "service-app-hr", fallbackFactory = HrHystrix.class)
public interface HrService {

//    /**
//     * loadUserByUsername
//     *
//     * @param username username
//     * @return UserDetails
//     */
//    @GetMapping("/load/{username}")
//    @Override
//    public UserDetails loadUserByUsername(@PathVariable("username") String username);

    /**
     * getAllHrs
     *
     * @param keywords keywords
     * @return List<Hr>
     */
    @GetMapping(value = "/{keywords}")
    public List<Hr> getAllHrs(@PathVariable("keywords") String keywords);

    /**
     * updateHr
     *
     * @param hr hr
     * @return Integer
     */
    @PutMapping(value = "/")
    public Integer updateHr(@RequestBody Hr hr);

    /**
     * updateHrRole
     *
     * @param hrid hrid
     * @param rids rids
     * @return boolean
     */
    @PutMapping(value = "/{hrid}")
    public boolean updateHrRole(@PathVariable("hrid") Integer hrid, @RequestBody Integer[] rids);

    /**
     * deleteHrById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteHrById(@PathVariable("id") Integer id);

    /**
     * getAllHrsExceptCurrentHr
     *
     * @return List<Hr>
     */
    @GetMapping(value = "/")
    public List<Hr> getAllHrsExceptCurrentHr() ;

    /**
     * updateHyById
     *
     * @param hr hr
     * @return Integer
     */
    @PutMapping(value = "/updateHyById")
    public Integer updateHyById(@RequestBody Hr hr);

    /**
     * updateHrPasswd
     *
     * @param oldpass oldpass
     * @param pass pass
     * @param hrid hrid
     * @return boolean
     */
    @PutMapping(value = "/{oldpass}/{pass}/{hrid}")
    public boolean updateHrPasswd(@PathVariable("oldpass") String oldpass, @PathVariable("pass") String pass, @PathVariable("hrid") Integer hrid) ;

    /**
     * updateUserface
     *
     * @param url url
     * @param id id
     * @return Integer
     */
    @PutMapping(value = "/{url}/{id}")
    public Integer updateUserface(@PathVariable("url") String url, @PathVariable("id") Integer id);
}
