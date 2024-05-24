package com.example.fastreachserve.controller.business;

import com.example.fastreachserve.service.business.BusinessDishService;
import dto.business.BusinessDishAddDTO;
import dto.business.BusinessDishEditDTO;
import dto.business.BusinessDishPageDTO;
import entity.Dish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import result.DishAddStruct;
import result.PageResult;
import result.Result;
import utils.OBSUtils;

/*
* 功能：菜品管理
* 负责人：
* */
@RestController
@Slf4j
@RequestMapping("/business/dish")
public class BusinessDishController {
    @Autowired
    private BusinessDishService businessDishService;
    private final OBSUtils obsUtils = new OBSUtils();
    @PostMapping("/upload")
    public Result upload(MultipartFile file,Integer id){
        String temp = obsUtils.upload(file);
        businessDishService.uploadPic(temp,id);
        return Result.sucess();
    }
    @GetMapping("/page")
    public Result<PageResult>page(BusinessDishPageDTO businessDishPageDTO){
        log.info("菜品分页查询：{}",businessDishPageDTO);
        PageResult pageResult =businessDishService.page(businessDishPageDTO);
        log.info("查询到的菜品为：{}",pageResult);
        return Result.sucess(pageResult);
    }
    @PostMapping("/edit")
    public Result edit(@RequestBody BusinessDishEditDTO businessDishEditDTO){
        log.info("菜品修改：{}",businessDishEditDTO);
        if(businessDishService.edit(businessDishEditDTO)){
            return Result.sucess();
        }
        return Result.error();
    }
    @PostMapping("/add")
    public Result<Integer> add(@RequestBody BusinessDishAddDTO businessDishAddDTO){
        log.info("菜品添加：{}",businessDishAddDTO);
        DishAddStruct dishAddStruct =businessDishService.add(businessDishAddDTO);
        if(dishAddStruct.isSuccess()){
            return Result.sucess(dishAddStruct.getDishId());
        }
        return Result.error();
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        log.info("菜品删除：{}",id);
        if(businessDishService.delete(id)){
            return Result.sucess();
        }
        return Result.error();
    }

    @GetMapping("/order/dish")
    public Result<Dish> getDishByOrderId(@RequestParam int id) {
        Dish dish = businessDishService.get(id);

        return Result.sucess(dish);
    }

}
