package vo.business;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BusinessOrderVO {
    private int id;
    private int userId;
    private String totalPrice;
    private int status;
    private String address;
    private LocalDateTime orderDate;
    private String orderedDishes;
}
