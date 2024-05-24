package dto.business;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessLoginDTO {
    public String account;
    public String password;
}
