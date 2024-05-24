package com.example.fastreachserve.service.business;

import dto.business.BusinessDishPageDTO;
import result.PageResult;

public interface BusinessUserService {
    PageResult page(String account);
    void recharge(String userId,String money,String addmoney);
}
