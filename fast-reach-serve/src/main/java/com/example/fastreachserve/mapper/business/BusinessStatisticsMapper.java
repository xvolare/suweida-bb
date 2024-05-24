package com.example.fastreachserve.mapper.business;

import dto.business.BusinessOrderDTO;
import entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.Date;
import java.util.List;

@Mapper
public interface BusinessStatisticsMapper {

    @Select("SELECT * FROM orders")
    List<BusinessOrderDTO> getAllOrderInfo();

    @Select("SELECT user_id FROM orders")
    List<String> getAllUserIds();

    @Select("SELECT order_date FROM orders")
    List<String> getAllOrderDates();

    @Select("SELECT ordered_dishes FROM orders")
    List<String> getAllOrderedDishes(); // assuming ordered_dishes is stored as a String

    @Select("SELECT total_price FROM orders")
    List<String> getAllTotalPrice();

    @Select("SELECT name FROM dishes")
    List<String> getAllDishNames();

    @Select("SELECT id FROM dishes WHERE name = #{name}")
    Integer getDishIdByName(String name);
}
