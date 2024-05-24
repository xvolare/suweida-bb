package com.example.fastreachserve.service.business;

import dto.business.BusinessLoginDTO;
import org.apache.ibatis.annotations.Mapper;
import vo.business.BusinessLoginVO;

public interface BusinessLoginService {
    BusinessLoginVO login(BusinessLoginDTO businessLoginDTO);
}
