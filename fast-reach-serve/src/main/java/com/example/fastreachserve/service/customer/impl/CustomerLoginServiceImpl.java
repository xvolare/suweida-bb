package com.example.fastreachserve.service.customer.impl;

import com.example.fastreachserve.mapper.customer.CustomerLoginMapper;
import com.example.fastreachserve.service.customer.CustomerLoginService;
import constant.business.BusinessLoginConstant;
import constant.customer.CustomerLoginConstant;
import dto.customer.CustomerLoginDTO;
import entity.Customer;
import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.JwtUtils;
import vo.business.BusinessLoginVO;
import vo.customer.CustomerLoginVO;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    CustomerLoginMapper customerLoginMapper;

    @Override
    public CustomerLoginVO login(CustomerLoginDTO customerLoginDTO) {
        //获取数据库的Employee对象
        Customer customer=customerLoginMapper.login(customerLoginDTO);
        log.info("实体类数据{}",customer);
        if(customer==null)return null;
        //赋值属性到CustomerLoginVO对象
        CustomerLoginVO customerLoginVO=new CustomerLoginVO();
        BeanUtils.copyProperties(customer,customerLoginVO);
        //生成并设置JWT令牌
        Map<String,Object> claims=new HashMap<>();
        claims.put("name",customer.getName());
        claims.put("password",customer.getPassword());//设置payload
        String jwt= JwtUtils.generateJwt(claims, CustomerLoginConstant.DEADLINE);
        log.info("JWT令牌:"+jwt);
        customerLoginVO.setToken(jwt);
        customerLoginVO.setId(customer.getId());
        return customerLoginVO;
    }
}
