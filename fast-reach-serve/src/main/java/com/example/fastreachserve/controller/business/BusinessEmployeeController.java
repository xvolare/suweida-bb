package com.example.fastreachserve.controller.business;

import com.example.fastreachserve.service.business.BusinessEmployeeService;
import dto.business.BusinessDishAddDTO;
import dto.business.BusinessEmployeePageDTO;
import dto.business.BussinessEmployeeAddDTO;
import dto.business.BussinessEmployeeEditDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.DishAddStruct;
import result.PageResult;
import result.Result;
import utils.OBSUtils;

import java.util.List;

/*
 * 功能：员工管理
 * 负责人：何子恒
 * */
@Slf4j
@RestController
@RequestMapping("/business/employee")
public class BusinessEmployeeController {

    @Autowired
    private BusinessEmployeeService businessEmployeeService;
    // 新增的员工分页查询方法
    @GetMapping("/page")
    public Result<PageResult>page(BusinessEmployeePageDTO businessEmployeePageDTO) {
        log.info("员工分页查询，{}",  businessEmployeePageDTO);
        // 调用服务层方法进行分页查询，这里假设返回一个PageResult对象
        PageResult pageResult = businessEmployeeService.page(businessEmployeePageDTO);
        log.info("TEST:",pageResult);
        return Result.sucess(pageResult);
    }
    //添加的功能-1
    @PostMapping("/add")
    public Result add(@RequestBody BussinessEmployeeAddDTO bussinessEmployeeAddDTO){
        if(businessEmployeeService.add(bussinessEmployeeAddDTO)){
            return Result.sucess();
        }else{
            return Result.error();
        }
    }
    //添加的功能-2
    @PostMapping("/edit")
    public Result edit(@RequestBody BussinessEmployeeEditDTO bussinessEmployeeEditDTO){
        if(businessEmployeeService.edit(bussinessEmployeeEditDTO)){
            return Result.sucess();
        }else{
            return Result.error();
        }
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        log.info("员工删除,id:{}",id);
        if(businessEmployeeService.delete(id)){
            return Result.sucess();
        }
        return Result.error();
    }
}




