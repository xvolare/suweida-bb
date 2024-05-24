package com.example.fastreachserve.service.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.customer.CustomerOrderDTO;

public interface CustomerOrderService {


    boolean order(CustomerOrderDTO customerOrderDTO) throws JsonProcessingException;
}
