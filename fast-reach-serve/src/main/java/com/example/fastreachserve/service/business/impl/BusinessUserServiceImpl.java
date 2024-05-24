package com.example.fastreachserve.service.business.impl;

import com.example.fastreachserve.mapper.business.BusinessUserMapper;
import com.example.fastreachserve.service.business.BusinessUserService;
import dto.business.BusinessDishPageDTO;
import entity.Customer;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.PageResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {
    @Autowired
    private BusinessUserMapper businessUserMapper;
    @Override
    public PageResult page(String account) {
        List<User>input = businessUserMapper.page(account);
        List<Customer> temp = new ArrayList<>() ;
        for(int i=0;i<input.size();++i){
            Customer customer = new Customer(input.get(i).getId(),input.get(i).getName(),input.get(i).getPhone(),
                    input.get(i).getPassword(),input.get(i).getAccount(),"￥"+input.get(i).getMoney().toString());
            temp.add(customer);
        }
        return new PageResult((long)temp.size(),temp);
    }

    @Override
    public void recharge(String userId, String money,String addmoney) {
        BigDecimal temp = new BigDecimal(money);
        temp=temp.add(new BigDecimal(addmoney));
        businessUserMapper.recharge(userId,temp);
    }
}
