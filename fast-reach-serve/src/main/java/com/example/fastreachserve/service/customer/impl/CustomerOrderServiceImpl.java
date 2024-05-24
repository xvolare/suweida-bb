package com.example.fastreachserve.service.customer.impl;

import com.example.fastreachserve.mapper.customer.CustomerOrderMapper;
import com.example.fastreachserve.service.customer.CustomerOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.customer.CustomerOrderDTO;
import entity.DishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    CustomerOrderMapper customerOrderMapper;



    @Override
    public boolean order(CustomerOrderDTO customerOrderDTO) throws JsonProcessingException {
        customerOrderMapper.editMoney(customerOrderDTO.getId(),customerOrderDTO.getMoney());


        List<Integer>order=new ArrayList<>();
        List<DishList>temp=customerOrderDTO.getDishList();

        for (int i=0;i<temp.size();++i){
            for (int j=0;j<temp.get(i).num;++j){
                order.add(temp.get(i).id);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(order);
        customerOrderDTO.setDishListFinal(jsonString);
        customerOrderDTO.setLocalDateTime(LocalDateTime.now());
        customerOrderDTO.setStatus(1);
        customerOrderMapper.editOrder(customerOrderDTO);
        return true;
    }
}
