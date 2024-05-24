package com.example.fastreachserve.service.customer.impl;

import com.example.fastreachserve.mapper.customer.CustomerUserMapper;
import com.example.fastreachserve.service.customer.CustomerUserService;


import dto.customer.CustomerUserAddDTO;
import dto.customer.CustomerUserEditDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerUserServiceImpl implements CustomerUserService {
    @Autowired
    private CustomerUserMapper customerUserMapper;


    @Override
    public boolean add(CustomerUserAddDTO customerUserAddDTO) {
        try {
            customerUserMapper.add(customerUserAddDTO);
            return true;
        } catch (Exception e) {
            log.error("用户注册失败：", e);
            return false;
        }
    }
    @Override
    public boolean edit(CustomerUserEditDTO customerUserEditDTO) {
        try {
            customerUserMapper.edit(customerUserEditDTO);
            return true;
        } catch (Exception e) {
            log.error("用户信息修改失败：", e);
            return false;
        }
    }
}
