package dto.business;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.valves.JsonAccessLogValve;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BusinessOrderDTO {
    private int orderId;
    private int userId;
    private String totalPrice;
    private int status;
    private String address;
    private LocalDateTime orderDate;
    private String orderedDishes;
}
//public class BusinessOrderDTO {
//    private int orderId;
//    private int customerId;
//    private String price;
//    private int status;
//    private String address;
//}
