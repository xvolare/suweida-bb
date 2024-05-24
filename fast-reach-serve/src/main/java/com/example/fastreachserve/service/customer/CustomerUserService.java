package com.example.fastreachserve.service.customer;

import dto.customer.CustomerUserAddDTO;
import dto.customer.CustomerUserEditDTO;

public interface CustomerUserService {

    boolean add(CustomerUserAddDTO customerUserAddDTO);

    boolean edit(CustomerUserEditDTO customerUserEditDTO);
}
