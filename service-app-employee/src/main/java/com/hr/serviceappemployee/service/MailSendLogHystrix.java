package com.hr.serviceappemployee.service;

import com.hr.model.MailSendLog;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 14:56:09
 */
@Component
public class MailSendLogHystrix implements FallbackFactory<MailSendLogService> {
    @Override
    public MailSendLogService create(Throwable throwable) {
        return new MailSendLogService() {
            @Override
            public Integer updateMailSendLogStatus(String msgId, Integer status) {
                return null;
            }

            @Override
            public Integer insert(MailSendLog mailSendLog) {
                return null;
            }

            @Override
            public List<MailSendLog> getMailSendLogsByStatus() {
                return null;
            }

            @Override
            public Integer updateCount(String msgId, Date date) {
                return null;
            }
        };
    }
}
