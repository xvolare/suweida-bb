package vo.customer;

import lombok.Data;

@Data
public class CustomerLoginVO {
    private int id;
    private String token;
    private String name;
    private String phoneNumber;
    private String password;
    private String account;
    private int money;

}
