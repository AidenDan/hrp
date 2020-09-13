package com.hr.serviceappemployee.controller;

import com.hr.model.Position;
import com.hr.serviceappemployee.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-9-12 18:22:55
 */
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    PositionService positionService;

    /**
     * getAllPositions
     *
     * @return List<Position>
     */
    @GetMapping(value = "/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    /**
     * addPosition
     *
     * @param position position
     * @return Integer
     */
    @PostMapping(value = "/")
    public Integer addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    /**
     * updatePositions
     *
     * @param position position
     * @return Integer
     */
    @PutMapping(value = "/")
    public Integer updatePositions(@RequestBody Position position){
        return positionService.updatePositions(position);
    }

    /**
     * deletePositionById
     *
     * @param id id
     * @return Integer
     */
    @DeleteMapping(value = "/{id}")
    public Integer deletePositionById(@PathVariable Integer id){
        return positionService.deletePositionById(id);
    }

    /**
     * deletePositionsByIds
     *
     * @param ids ids
     * @return Integer
     */
    @DeleteMapping(value = "/deletePositionsByIds")
    public Integer deletePositionsByIds(@RequestBody Integer[] ids){
        return positionService.deletePositionsByIds(ids);
    }
}
