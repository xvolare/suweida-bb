package com.example.fastreachserve.mapper.business;

import dto.business.BusinessEmployeePageDTO;
import dto.business.BussinessEmployeeAddDTO;
import dto.business.BussinessEmployeeEditDTO;
import entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface BusinessEmployeeMapper {
    //@Select("select * from employees")
    List<Employee> page(BusinessEmployeePageDTO businessEmployeePageDTO);
    @Delete("DELETE from employees  WHERE id = #{id}")
    void delete(int id);

    @Insert("INSERT INTO employees (name, account, password, phone,sex,permission) VALUES (#{name},#{account},#{password},#{phone},#{sex},#{permission})")
    void add(BussinessEmployeeAddDTO businessDishAddDTO);

    @Update("UPDATE employees SET name = #{name},password=#{password},phone=#{phone},sex=#{sex},permission=#{permission}  WHERE id = #{id}")
    void edit(BussinessEmployeeEditDTO bussinessEmployeeEditDTO);
}