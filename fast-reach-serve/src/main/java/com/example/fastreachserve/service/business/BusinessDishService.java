package com.example.fastreachserve.service.business;

import dto.business.BusinessDishAddDTO;
import dto.business.BusinessDishEditDTO;
import dto.business.BusinessDishPageDTO;
import entity.Dish;
import result.DishAddStruct;
import result.PageResult;

public interface BusinessDishService {
    void uploadPic(String temp, Integer id);

    PageResult page(BusinessDishPageDTO businessDishPageDTO);
    boolean edit(BusinessDishEditDTO businessDishEditDTO);

    boolean delete(int id);

    DishAddStruct add(BusinessDishAddDTO businessDishAddDTO);

    Dish get(int id);
}
