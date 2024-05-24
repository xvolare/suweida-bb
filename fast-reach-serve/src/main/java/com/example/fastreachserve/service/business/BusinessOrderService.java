package com.example.fastreachserve.service.business;

import org.apache.ibatis.annotations.Mapper;
import dto.business.BusinessOrderDTO;
import vo.business.BusinessOrderVO;

import java.util.List;

public interface BusinessOrderService {
    void deleteOrder(int orderId);

    void editOrderStatus(int orderId, int status);

    List<BusinessOrderVO> getPageOrders(int page);
    List<BusinessOrderVO> getOrdersByStatus(int status);

    BusinessOrderVO getPageOrderDetail(int orderId);
    Long getTotalOrdersCount();
}
