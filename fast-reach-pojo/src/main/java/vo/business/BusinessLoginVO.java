package vo.business;

import lombok.Data;

@Data
public class BusinessLoginVO {
    private int id;
    private String token;
    private String name;
    private int permission;
}
