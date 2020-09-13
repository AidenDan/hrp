package com.hr.serviceappemployee.controller;

import com.hr.model.MailSendLog;
import com.hr.serviceappemployee.service.MailSendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:01:08
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    MailSendLogService mailSendLogService;

    /**
     * updateMailSendLogStatus
     *
     * @param msgId msgId
     * @param status status
     * @return Integer
     */
    @PutMapping(value = "/{msgId}/{status}")
    public Integer updateMailSendLogStatus(@PathVariable String msgId, @PathVariable Integer status) {
        return mailSendLogService.updateMailSendLogStatus(msgId, status);
    }

    /**
     * insert
     *
     * @param mailSendLog mailSendLog
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer insert(@RequestBody MailSendLog mailSendLog){
        return mailSendLogService.insert(mailSendLog);
    }

    /**
     * getMailSendLogsByStatus
     *
     * @return List<MailSendLog>
     */
    @PostMapping(value = "/getMailSendLogsByStatus")
    public List<MailSendLog> getMailSendLogsByStatus(){
        return mailSendLogService.getMailSendLogsByStatus();
    }

    /**
     * updateCount
     *
     * @param msgId msgId
     * @param date date
     * @return Integer
     */
    @PutMapping(value = "/{msgId}")
    public Integer updateCount(@PathVariable String msgId, @RequestBody Date date){
        return mailSendLogService.updateCount(msgId, date);
    }
}
