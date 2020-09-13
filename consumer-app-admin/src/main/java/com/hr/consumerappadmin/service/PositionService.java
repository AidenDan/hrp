package com.hr.consumerappadmin.service;

import com.hr.consumerappadmin.service.fallback.PositionHystrix;
import com.hr.model.Position;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 15:23:46
 */
@FeignClient(value = "service-app-position", fallbackFactory = PositionHystrix.class)
public interface PositionService {

    /**
     * getAllPositions
     *
     * @return List<Position>
     */
    @GetMapping(value = "/")
    public List<Position> getAllPositions();

    /**
     * addPosition
     *
     * @param position position
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addPosition(@RequestBody Position position) ;

    /**
     * updatePositions
     *
     * @param position position
     * @return Integer
     */
    @PutMapping(value = "/")
    public Integer updatePositions(@RequestBody Position position);

    /**
     * deletePositionById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}")
    public Integer deletePositionById(@PathVariable Integer id);

    /**
     * deletePositionsByIds
     *
     * @param ids ids
     * @return Integer
     */
    @DeleteMapping(value = "/deletePositionsByIds")
    public Integer deletePositionsByIds(@RequestBody Integer[] ids);
}
