package com.example.fastreachserve.service.business.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.business.BusinessDishAddDTO;
import dto.business.BusinessDishEditDTO;
import lombok.extern.slf4j.Slf4j;
import result.DishAddStruct;
import result.PageResult;
import com.example.fastreachserve.mapper.business.BusinessDishMapper;
import com.example.fastreachserve.service.business.BusinessDishService;

import dto.business.BusinessDishPageDTO;
import entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusinessDishServiceImpl implements BusinessDishService {
    @Autowired
    BusinessDishMapper businessDishMapper;

    @Override
    public void uploadPic(String temp, Integer id) {
        businessDishMapper.uploadPic(temp,id);
    }

    @Override
    public PageResult page(BusinessDishPageDTO businessDishPageDTO) {

        PageHelper.startPage(1,10);
        List<Dish> page = businessDishMapper.page(businessDishPageDTO);
        PageInfo<Dish> pageInfo = new PageInfo<Dish>(page);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());

    }

    @Override
    public boolean edit(BusinessDishEditDTO businessDishEditDTO) {
        try{
            businessDishMapper.edit(businessDishEditDTO);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try{
            businessDishMapper.delete(id);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public DishAddStruct add(BusinessDishAddDTO businessDishAddDTO) {
        DishAddStruct dishAddStruct =new DishAddStruct();
        try{
            businessDishMapper.add(businessDishAddDTO);
            log.info("新添加菜品的id是{}",businessDishAddDTO.getId());
            dishAddStruct.setDishId(businessDishAddDTO.getId());
            dishAddStruct.setSuccess(true);
        }
        catch(Exception e){
            dishAddStruct.setDishId(-1);
            dishAddStruct.setSuccess(false);
        }
        return dishAddStruct;
    }

    @Override
    public Dish get(int dishId) {
        return businessDishMapper.get(dishId);
    }
}
