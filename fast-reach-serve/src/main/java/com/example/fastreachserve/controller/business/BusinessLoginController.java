package com.example.fastreachserve.controller.business;

import com.example.fastreachserve.service.business.BusinessLoginService;
import dto.business.BusinessLoginDTO;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.business.BusinessLoginVO;

/*
 * 功能：登录模块
 * 负责人：徐硕洋
 * */
@RestController
@RequestMapping("/business")
@Slf4j
public class BusinessLoginController {
    @Autowired
    BusinessLoginService businessLoginService;
    /*
    * 商家登录
    * */
    @PostMapping("/employee/login")
    public Result login(@RequestBody BusinessLoginDTO businessLoginDTO){
        log.info("商家登录{}",businessLoginDTO);
        BusinessLoginVO businessLoginVO=businessLoginService.login(businessLoginDTO);
        if(businessLoginVO!=null){return Result.sucess(businessLoginVO);}
        else {return Result.error();}
    }
}
