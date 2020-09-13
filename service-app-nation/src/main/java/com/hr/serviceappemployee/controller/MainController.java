package com.hr.serviceappemployee.controller;

import com.hr.model.Nation;
import com.hr.serviceappemployee.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:16:36
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    NationService nationService;

    /**
     * getAllNations
     *
     * @return List<Nation>
     */
    @GetMapping("/")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }
}
