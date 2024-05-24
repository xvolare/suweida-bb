package com.example.fastreachserve.controller.business;

import com.example.fastreachserve.service.business.BusinessUserService;
import dto.business.BusinessDishPageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.PageResult;
import result.Result;

@RestController
@Slf4j
@RequestMapping("/business/user")
public class BusinessUserController {
    @Autowired
    private BusinessUserService businessUserService;
    @GetMapping("/page")
    public Result<PageResult> page(String account){
        log.info("用户分页查询：{}",account);
        PageResult pageResult =businessUserService.page(account);
        log.info("查询到的用户为：{}",pageResult);
        return Result.sucess(pageResult);
    }

    @GetMapping("/recharge")
    public Result recharge(String userId,String money,String addmoney){
        log.info("{}用户充值金额：{}",userId,addmoney);
        businessUserService.recharge(userId,money,addmoney);
        return Result.sucess();
    }
}
