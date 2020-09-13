package com.hr.consumerappadmin.service.fallback;

import com.hr.consumerappadmin.service.PositionService;
import com.hr.model.Position;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:25:13
 */
@Component
public class PositionHystrix implements FallbackFactory<PositionService> {
    @Override
    public PositionService create(Throwable throwable) {
        return new PositionService() {
            @Override
            public List<Position> getAllPositions() {
                return null;
            }

            @Override
            public Integer addPosition(Position position) {
                return null;
            }

            @Override
            public Integer updatePositions(Position position) {
                return null;
            }

            @Override
            public Integer deletePositionById(Integer id) {
                return null;
            }

            @Override
            public Integer deletePositionsByIds(Integer[] ids) {
                return null;
            }
        };
    }
}
