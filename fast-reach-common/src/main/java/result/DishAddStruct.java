package result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishAddStruct {
    private boolean isSuccess;
    private Integer dishId;
}
