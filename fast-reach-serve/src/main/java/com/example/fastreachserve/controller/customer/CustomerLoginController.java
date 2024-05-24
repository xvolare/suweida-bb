package com.example.fastreachserve.controller.customer;

/*
 * 功能：顾客登录
 * 负责人：
 * */

import com.example.fastreachserve.service.customer.CustomerLoginService;
import dto.business.BusinessLoginDTO;
import dto.customer.CustomerLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import vo.business.BusinessLoginVO;
import vo.customer.CustomerLoginVO;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerLoginController {
    @Autowired
    CustomerLoginService customerLoginService;

    @PostMapping("/user/login")
    public Result login(@RequestBody CustomerLoginDTO customerLoginDTO){
        log.info("顾客登录{}",customerLoginDTO);
        CustomerLoginVO customerLoginVO=customerLoginService.login(customerLoginDTO);
        log.info("顾客登录得到数据{},",customerLoginVO);
        if(customerLoginVO!=null){return Result.sucess(customerLoginVO);}
        else {return Result.error();}
    }
}
