package com.example.fastreachserve.service.customer.impl;

import com.example.fastreachserve.mapper.customer.CustomerModifyMapper;
import com.example.fastreachserve.service.customer.CustomerModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerModifyServiceImpl implements CustomerModifyService {
    @Autowired
    CustomerModifyMapper customerModifyMapper;
}
