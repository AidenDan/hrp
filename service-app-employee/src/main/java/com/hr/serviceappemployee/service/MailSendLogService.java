package com.hr.serviceappemployee.service;

import com.hr.model.MailSendLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 14:54:48
 */
@FeignClient(value = "service-app-mail-send-log", fallbackFactory = MailSendLogHystrix.class)
public interface MailSendLogService {

    /**
     * updateMailSendLogStatus
     *
     * @param msgId msgId
     * @param status status
     * @return Integer
     */
    @PutMapping(value = "/{msgId}/{status}")
    public Integer updateMailSendLogStatus(@PathVariable String msgId, @PathVariable Integer status) ;

    /**
     * insert
     *
     * @param mailSendLog mailSendLog
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer insert(@RequestBody MailSendLog mailSendLog);

    /**
     * getMailSendLogsByStatus
     *
     * @return List<MailSendLog>
     */
    @GetMapping(value = "/")
    public List<MailSendLog> getMailSendLogsByStatus();

    /**
     * updateCount
     *
     * @param msgId msgId
     * @param date date
     * @return Integer
     */
    @PutMapping(value = "/{msgId}")
    public Integer updateCount(@PathVariable String msgId, @RequestBody Date date);
}
