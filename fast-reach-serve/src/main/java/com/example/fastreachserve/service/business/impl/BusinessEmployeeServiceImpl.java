package com.example.fastreachserve.service.business.impl;

import com.example.fastreachserve.mapper.business.BusinessEmployeeMapper;
import com.example.fastreachserve.service.business.BusinessEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.business.BusinessDishPageDTO;
import dto.business.BusinessEmployeePageDTO;
import dto.business.BussinessEmployeeAddDTO;
import dto.business.BussinessEmployeeEditDTO;
import entity.Dish;
import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import result.PageResult;

import java.util.List;

@Service
@Slf4j
public class BusinessEmployeeServiceImpl implements BusinessEmployeeService {
    @Autowired
    BusinessEmployeeMapper businessEmployeeMapper;

    @Override
    public PageResult page(BusinessEmployeePageDTO businessEmployeePageDTO) {

        //设置分页参数
        PageHelper.startPage(1,10);

        //执行查询
        List<Employee> page = businessEmployeeMapper.page(businessEmployeePageDTO);
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(page);
        log.info("fef{}",pageInfo.getSize());
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public boolean add(BussinessEmployeeAddDTO bussinessEmployeeAddDTO) {
        try{
            businessEmployeeMapper.add(bussinessEmployeeAddDTO);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean edit(BussinessEmployeeEditDTO bussinessEmployeeEditDTO) {
        try{
            businessEmployeeMapper.edit(bussinessEmployeeEditDTO);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    @Override
    public boolean delete(int id)
    {
        try {
            businessEmployeeMapper.delete(id);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }


}