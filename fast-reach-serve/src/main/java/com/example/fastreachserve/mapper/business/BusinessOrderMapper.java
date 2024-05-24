package com.example.fastreachserve.mapper.business;

import org.apache.ibatis.annotations.*;
import dto.business.BusinessOrderDTO;
import vo.business.BusinessOrderVO;

import java.util.List;

@Mapper
public interface BusinessOrderMapper {

    @Delete("DELETE FROM orders WHERE id = #{orderId}")
    void deleteOrder(int orderId);

    @Update("UPDATE orders SET status = #{status} WHERE order_id = #{orderId}")
    void editOrderStatus(@Param("orderId") int orderId, @Param("status") int status);

    @Select("SELECT * FROM orders LIMIT #{pageSize} OFFSET #{offset}")
    List<BusinessOrderDTO> getPageOrders(@Param("pageSize") int pageSize, @Param("offset") int offset);

    @Select("SELECT * FROM orders WHERE order_id = #{orderId}")
    BusinessOrderDTO getOrderDetail(int orderId);

    @Select("SELECT * FROM orders WHERE status = #{status}")
    List<BusinessOrderVO> getOrdersByStatus(int status);

    @Select("SELECT COUNT(*) FROM orders")
    Long getTotalOrdersCount();


}
