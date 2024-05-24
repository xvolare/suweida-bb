package dto.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adamaik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDishEditDTO {
    private String description;
    private String price;
    private String name;
    private int status;
    private int id;
}
