package com.example.fastreachserve.service.business;

import com.example.fastreachserve.controller.business.BusinessEmployeeController;
import dto.business.BusinessDishPageDTO;
import dto.business.BusinessEmployeePageDTO;
import dto.business.BussinessEmployeeAddDTO;
import dto.business.BussinessEmployeeEditDTO;
import org.apache.ibatis.annotations.Mapper;
import result.PageResult;

import java.util.List;

public interface BusinessEmployeeService {

    PageResult page(BusinessEmployeePageDTO businessEmployeePageDTO);

    boolean add(BussinessEmployeeAddDTO businessDishAddDTO);

    boolean delete(int id);
    boolean edit(BussinessEmployeeEditDTO bussinessEmployeeEditDTO);
}
