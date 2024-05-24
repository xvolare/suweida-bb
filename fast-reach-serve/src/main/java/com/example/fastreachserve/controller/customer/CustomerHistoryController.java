package com.example.fastreachserve.controller.customer;

import com.example.fastreachserve.service.customer.CustomerHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/*
 * 功能：历史订单查询
 * 负责人：
 * */
@RestController
public class CustomerHistoryController {
    @Autowired
    CustomerHistoryService customerHistoryService;
}
