package com.example.fastreachserve.service.business.impl;

import cn.hutool.json.ObjectMapper;
import com.example.fastreachserve.mapper.business.BusinessOrderMapper;
import com.example.fastreachserve.service.business.BusinessOrderService;
import dto.business.BusinessOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.business.BusinessOrderVO;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class BusinessOrderServiceImpl implements BusinessOrderService {

    private final BusinessOrderMapper businessOrderMapper;

    @Autowired
    public BusinessOrderServiceImpl(BusinessOrderMapper businessOrderMapper) {
        this.businessOrderMapper = businessOrderMapper;
    }

    @Override
    public void deleteOrder(int orderId) {
        businessOrderMapper.deleteOrder(orderId);
    }

    @Override
    public void editOrderStatus(int orderId, int status) {
        businessOrderMapper.editOrderStatus(orderId, status);
    }

    @Override
    public List<BusinessOrderVO> getPageOrders(int page) {
        int pageSize = 10; // 每页显示的订单数量
        int offset = (page - 1) * pageSize; // 计算偏移量
        List<BusinessOrderDTO> orderDTOs = businessOrderMapper.getPageOrders(pageSize, offset);
        // 转换DTO为VO
        return convertToVOList(orderDTOs);
    }

    public List<BusinessOrderVO> getOrdersByStatus(int status) {
        return businessOrderMapper.getOrdersByStatus(status);
    }

    public Long getTotalOrdersCount() {
        return businessOrderMapper.getTotalOrdersCount();
    }

    @Override
    public BusinessOrderVO getPageOrderDetail(int orderId) {
        BusinessOrderDTO orderDTO = businessOrderMapper.getOrderDetail(orderId);
        // 转换DTO为VO
        return convertToVO(orderDTO);
    }

    // 转换DTO为VO
    private BusinessOrderVO convertToVO(BusinessOrderDTO orderDTO) {

        if (orderDTO == null) {
            return null;
        }
        BusinessOrderVO orderVO = new BusinessOrderVO();
        orderVO.setId(orderDTO.getOrderId());
        orderVO.setUserId(orderDTO.getUserId());
        orderVO.setTotalPrice(orderDTO.getTotalPrice());
        orderVO.setStatus(orderDTO.getStatus());
        orderVO.setAddress(orderDTO.getAddress());
        orderVO.setOrderDate(orderDTO.getOrderDate());
        orderVO.setOrderedDishes(orderDTO.getOrderedDishes());
        log.info(String.valueOf(orderVO));
        return orderVO;

    }

    // 转换DTO列表为VO列表
    private List<BusinessOrderVO> convertToVOList(List<BusinessOrderDTO> orderDTOs) {
        return orderDTOs.stream().map(this::convertToVO).collect(Collectors.toList());
    }
}
