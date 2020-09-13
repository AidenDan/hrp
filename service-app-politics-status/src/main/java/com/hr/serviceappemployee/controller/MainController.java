package com.hr.serviceappemployee.controller;

import com.hr.model.Politicsstatus;
import com.hr.serviceappemployee.service.PoliticsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:19:02
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    PoliticsstatusService politicsstatusService;

    /**
     * getAllPoliticsstatus
     *
     * @return List<Politicsstatus>
     */
    @GetMapping(value = "/")
    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }
}
