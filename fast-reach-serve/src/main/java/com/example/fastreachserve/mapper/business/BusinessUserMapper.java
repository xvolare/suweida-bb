package com.example.fastreachserve.mapper.business;

import dto.business.BusinessDishPageDTO;
import entity.Customer;
import entity.Dish;
import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface BusinessUserMapper {
    List<User> page(String account);
    @Update("UPDATE users SET money = #{money}  WHERE user_id = #{userId}")
    void recharge(String userId, BigDecimal money);
}
