package com.example.fastreachserve.mapper.customer;


import dto.customer.CustomerUserAddDTO;
import dto.customer.CustomerUserEditDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface CustomerUserMapper {

    @Insert("INSERT INTO users (account, password, phone) VALUES (#{account},#{password},#{phone})")
    void add(CustomerUserAddDTO customerUserAddDTO);

    @Update("UPDATE users SET name = #{name},password=#{password},phone=#{phone} WHERE id = #{id}")
    void edit(CustomerUserEditDTO customerUserEditDTO);
}
