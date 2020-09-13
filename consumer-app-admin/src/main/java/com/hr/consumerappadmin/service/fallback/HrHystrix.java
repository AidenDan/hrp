package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.HrService;
import com.hr.model.Hr;
import feign.hystrix.FallbackFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 13:38:41
 */
@Component
public class HrHystrix implements FallbackFactory<HrService> {
    @Override
    public HrService create(Throwable throwable) {
        return new HrService() {
            @Override
            public List<Hr> getAllHrs(String keywords) {
                return null;
            }

            @Override
            public Integer updateHr(Hr hr) {
                return null;
            }

            @Override
            public boolean updateHrRole(Integer hrid, Integer[] rids) {
                return false;
            }

            @Override
            public Integer deleteHrById(Integer id) {
                return null;
            }

            @Override
            public List<Hr> getAllHrsExceptCurrentHr() {
                return null;
            }

            @Override
            public Integer updateHyById(Hr hr) {
                return null;
            }

            @Override
            public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
                return false;
            }

            @Override
            public Integer updateUserface(String url, Integer id) {
                return null;
            }
        };
    }
}
