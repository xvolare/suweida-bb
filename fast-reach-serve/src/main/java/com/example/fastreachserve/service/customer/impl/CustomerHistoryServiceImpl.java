package com.example.fastreachserve.service.customer.impl;

import com.example.fastreachserve.mapper.customer.CustomerHistoryMapper;
import com.example.fastreachserve.service.customer.CustomerHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerHistoryServiceImpl implements CustomerHistoryService {
    @Autowired
    CustomerHistoryMapper customerHistoryMapper;
}
