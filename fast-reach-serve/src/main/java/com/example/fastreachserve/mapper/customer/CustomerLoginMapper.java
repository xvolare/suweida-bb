package com.example.fastreachserve.mapper.customer;

import dto.customer.CustomerLoginDTO;
import entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerLoginMapper {
    @Select("select * from users where account=#{account} AND password=#{password}")
    Customer login(CustomerLoginDTO customerLoginDTO);
}
