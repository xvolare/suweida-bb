package com.example.fastreachserve.mapper.business;

import com.github.pagehelper.Page;
import dto.business.BusinessDishAddDTO;
import dto.business.BusinessDishEditDTO;
import dto.business.BusinessDishPageDTO;
import entity.Dish;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BusinessDishMapper {
    @Update("UPDATE dishes SET image = #{temp} WHERE id = #{id}")
    void uploadPic(String temp, Integer id);

    //@Select("select * from dishes")
    List<Dish> page(BusinessDishPageDTO businessDishPageDTO);

    @Update("UPDATE dishes SET price = #{price},name=#{name},description=#{description},status=#{status}  WHERE id = #{id}")
    void edit(BusinessDishEditDTO businessDishEditDTO);

    @Delete("DELETE from dishes  WHERE id = #{id}")
    void delete(int id);

    @Insert("INSERT INTO dishes (name, price, description, status) VALUES (#{name},#{price},#{description},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void add(BusinessDishAddDTO businessDishAddDTO);

    @Select("SELECT * FROM dishes WHERE id = #{id}")
    Dish get(int id);
}
