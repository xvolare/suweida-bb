package entity;

import com.fasterxml.jackson.databind.JsonNode;
import jdk.jfr.Unsigned;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private int orderId;
    private int userId; // 修改字段名为 userId
    private String totalPrice; // 修改字段名为 totalPrice
    private int status;
    private String address;
    private LocalDateTime orderDate; // 修改字段名为 orderDate
    private String orderedDishes; // 修改字段名为 orderedDishes
}

//public class Order {
//    private int id;
//    private int customer_id;//用户（顾客）主键
//    private String price;//总价格，防止精度丢失，所以用String，后端要处理
//    private int status;//（0是未接单，1是已结单，2是派送中，3是已完成）
//    private String address;//派送地址
//    private LocalDateTime createTime;//订单创建时间
//}
