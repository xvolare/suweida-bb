package com.example.fastreachserve.service.business.impl;

import com.example.fastreachserve.mapper.business.BusinessLoginMapper;
import com.example.fastreachserve.service.business.BusinessLoginService;
import constant.business.BusinessLoginConstant;
import dto.business.BusinessLoginDTO;
import entity.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.JwtUtils;
import vo.business.BusinessLoginVO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class BusinessLoginServiceImpl implements BusinessLoginService {
    @Autowired
    BusinessLoginMapper businessLoginMapper;
    @Override
    public BusinessLoginVO login(BusinessLoginDTO businessLoginDTO) {
        //获取数据库的Employee对象
        Employee employee=businessLoginMapper.login(businessLoginDTO);
        if(employee==null)return null;
        //赋值属性到BusinessLoginVO对象
        BusinessLoginVO businessLoginVO=new BusinessLoginVO();
        BeanUtils.copyProperties(employee,businessLoginVO);
        //生成并设置JWT令牌
        Map<String,Object>claims=new HashMap<>();
        claims.put("name",employee.getName());
        claims.put("password",employee.getPassword());//设置payload
        String jwt= JwtUtils.generateJwt(claims, BusinessLoginConstant.DEADLINE);
        log.info("JWT令牌:"+jwt);
        businessLoginVO.setToken(jwt);
        return businessLoginVO;
    }
}