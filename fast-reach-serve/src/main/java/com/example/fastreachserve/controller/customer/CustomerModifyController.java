package com.example.fastreachserve.controller.customer;

import com.example.fastreachserve.service.customer.CustomerModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/*
 * 功能：顾客注册及信息修改
 * 负责人：
 * */
@RestController
public class CustomerModifyController {
    @Autowired
    CustomerModifyService customerModifyService;
}
