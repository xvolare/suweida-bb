package dto.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDishPageDTO {
    private String name;
    private int status;
    private int page;
}
