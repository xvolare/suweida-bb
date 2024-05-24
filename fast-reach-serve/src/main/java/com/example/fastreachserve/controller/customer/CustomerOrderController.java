package com.example.fastreachserve.controller.customer;

import com.example.fastreachserve.service.customer.CustomerOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.customer.CustomerLoginDTO;
import dto.customer.CustomerOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.PageResult;
import result.Result;
import vo.business.BusinessOrderVO;

import java.util.List;

/*
 * 功能：顾客点餐
 * 负责人：
 * */
@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;
    @PostMapping ("/order/submit")
    public Result order(@RequestBody CustomerOrderDTO customerOrderDTO) {
        log.info("订餐数据:{}",customerOrderDTO);
        try {
            customerOrderService.order(customerOrderDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Result.sucess();
    }
}
