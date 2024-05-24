package com.example.fastreachserve.mapper.business;

import dto.business.BusinessLoginDTO;
import entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import vo.business.BusinessLoginVO;

@Mapper
public interface BusinessLoginMapper {
    //防止SQL注入，保证安全和效率
    @Select("select * from employees where account=#{account} AND password=#{password}")
    Employee login(BusinessLoginDTO businessLoginDTO);
}
