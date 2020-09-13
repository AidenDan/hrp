package com.hr.serviceappemployee.controller;

import com.hr.model.Hr;
import com.hr.serviceappemployee.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 17:44:21
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    HrService hrService;

//    /**
//     * loadUserByUsername
//     *
//     * @param username username
//     * @return UserDetails
//     */
//    @GetMapping("/load/{username}")
//    public UserDetails loadUserByUsername(@PathVariable("username") String username){
//        return hrService.loadUserByUsername(username);
//    }

    /**
     * getAllHrs
     *
     * @param keywords keywords
     * @return List<Hr>
     */
    @GetMapping(value = "/{keywords}")
    public List<Hr> getAllHrs(@PathVariable("keywords") String keywords){
        return hrService.getAllHrs(keywords);
    }

    /**
     * updateHr
     *
     * @param hr hr
     * @return Integer
     */
    @PutMapping(value = "/")
    public Integer updateHr(@RequestBody Hr hr){
        return hrService.updateHr(hr);
    }

    /**
     * updateHrRole
     *
     * @param hrid hrid
     * @param rids rids
     * @return boolean
     */
    @PutMapping(value = "/{hrid}")
    public boolean updateHrRole(@PathVariable("hrid") Integer hrid, @RequestBody Integer[] rids){
        return hrService.updateHrRole(hrid, rids);
    }

    /**
     * deleteHrById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteHrById(@PathVariable("id") Integer id){
        return hrService.deleteHrById(id);
    }

    /**
     * getAllHrsExceptCurrentHr
     *
     * @return List<Hr>
     */
    @GetMapping(value = "/")
    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrService.getAllHrsExceptCurrentHr();
    }

    /**
     * updateHyById
     *
     * @param hr hr
     * @return Integer
     */
    @PutMapping(value = "/updateHyById")
    public Integer updateHyById(@RequestBody Hr hr){
        return hrService.updateHyById(hr);
    }

    /**
     * updateHrPasswd
     *
     * @param oldpass oldpass
     * @param pass pass
     * @param hrid hrid
     * @return boolean
     */
    @PutMapping(value = "/{oldpass}/{pass}/{hrid}")
    public boolean updateHrPasswd(@PathVariable("oldpass") String oldpass, @PathVariable("pass") String pass, @PathVariable("hrid") Integer hrid){
        return hrService.updateHrPasswd(oldpass, pass, hrid);
    }

    /**
     * updateUserface
     *
     * @param url url
     * @param id id
     * @return Integer
     */
    @PutMapping(value = "/{url}/{id}")
    public Integer updateUserface(@PathVariable("url") String url, @PathVariable("id") Integer id){
        return hrService.updateUserface(url, id);
    }
}
