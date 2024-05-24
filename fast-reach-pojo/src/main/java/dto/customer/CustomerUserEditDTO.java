package dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CustomerUserEditDTO {
    private int id;
    private String phone;
    private String password;
    private String account;
}


