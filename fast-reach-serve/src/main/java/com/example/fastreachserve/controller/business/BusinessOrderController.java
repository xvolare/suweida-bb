package com.example.fastreachserve.controller.business;

import com.example.fastreachserve.service.business.BusinessOrderService;
import dto.business.BusinessOrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import result.PageResult;
import result.Result;
import vo.business.BusinessOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business/order")
public class BusinessOrderController {

    private final BusinessOrderService businessOrderService;

    @Autowired
    public BusinessOrderController(BusinessOrderService businessOrderService) {
        this.businessOrderService = businessOrderService;
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam("orderId") int orderId) {
        businessOrderService.deleteOrder(orderId);
    }

    @PutMapping("/edit")
    public void editOrderStatus(@RequestParam("orderId") int orderId, @RequestParam("status") int status) {
        businessOrderService.editOrderStatus(orderId, status);
    }

    @GetMapping("/page")
    public Result<PageResult> getPageOrders(@RequestParam("page") int page) {
//        log.info("订单分页查询：{}", page);
        List<BusinessOrderVO> orderList = businessOrderService.getPageOrders(page);
        Long total = businessOrderService.getTotalOrdersCount();
        PageResult pageResult = new PageResult(total, orderList);
        return Result.sucess(pageResult);
    }

    @GetMapping("/page/detail")
    public Result<BusinessOrderVO> getPageOrderDetail(@RequestParam("orderId") int orderId) {
        BusinessOrderVO orderDetail = businessOrderService.getPageOrderDetail(orderId);
        return Result.sucess(orderDetail);
    }

    @GetMapping("/page/detail/status")
    public Result<PageResult> getPageOrderByStatus(@RequestParam("status") int status) {
        List<BusinessOrderVO> orderStatusList = businessOrderService.getOrdersByStatus(status);
        Long total = businessOrderService.getTotalOrdersCount();
        PageResult pageStatusResult = new PageResult(total, orderStatusList);
        return Result.sucess(pageStatusResult);
    }




}
