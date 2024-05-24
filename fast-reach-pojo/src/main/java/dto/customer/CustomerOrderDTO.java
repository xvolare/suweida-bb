package dto.customer;

import entity.DishList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerOrderDTO {
    private Double money;
    private Double totalPrice;
    private LocalDateTime localDateTime;
    private int id;
    private int status;
    private String address;
    private List<DishList> dishList;
    private String dishListFinal;
}
