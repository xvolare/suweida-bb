package dto.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerLoginDTO {
    public String account;
    public String password;
}
