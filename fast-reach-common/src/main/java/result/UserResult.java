package result;

import entity.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResult {
    /**
     * 返回每天的订单数
    */
    private List<String> dateList;
    private List<Integer> orderNumList;
}
