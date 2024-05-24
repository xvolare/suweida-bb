package com.example.fastreachserve.mapper.customer;

import dto.customer.CustomerOrderDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CustomerOrderMapper {
    @Update("UPDATE users SET money=#{money} WHERE user_id = #{id}")
    void editMoney(int id,Double money);
@Insert("INSERT INTO orders (address,user_id,total_price,status,order_date,ordered_dishes)\n" +
        "  VALUES (#{address},#{id},#{totalPrice},#{status},#{localDateTime},#{dishListFinal})")
    void editOrder(CustomerOrderDTO customerOrderDTO);
}
