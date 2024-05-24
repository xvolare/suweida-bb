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
public class TurnoverResult implements Serializable {
    private List<String> dateList;
    private List<String> turnoverList;
}
