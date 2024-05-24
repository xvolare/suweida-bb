package com.example.fastreachserve.service.customer;

import dto.customer.CustomerLoginDTO;
import vo.customer.CustomerLoginVO;

public interface CustomerLoginService {
    CustomerLoginVO login(CustomerLoginDTO customerLoginDTO);
}
