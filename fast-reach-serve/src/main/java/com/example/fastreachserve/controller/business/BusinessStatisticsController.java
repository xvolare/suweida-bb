package com.example.fastreachserve.controller.business;

import com.example.fastreachserve.service.business.BusinessStatisticsService;
import entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import result.DishNumResult;
import result.TurnoverResult;
import result.UserResult;

/*
 * 功能：数据统计
 * 负责人：沈浩天
 * */
@RestController
@RequestMapping("/business/report")
public class BusinessStatisticsController {
    @Autowired
    BusinessStatisticsService businessStatisticsService;

    @GetMapping("/turnover")
    public Result<TurnoverResult> getTurnover() {
        TurnoverResult turnover = businessStatisticsService.getTurnover();
        return Result.sucess(turnover);
    }

    @GetMapping("/user")
    public Result<UserResult> getUser() {
        UserResult user = businessStatisticsService.getUser();
        return Result.sucess(user);
    }

    @GetMapping("/top")
    public Result<DishNumResult> getTop() {
        DishNumResult dishNum = businessStatisticsService.getDishNum();
        return Result.sucess(dishNum);
    }
}

