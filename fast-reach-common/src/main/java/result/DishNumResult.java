package result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishNumResult {
    private List<String> nameList; // 菜品名称列表
    private List<Integer> numberList; // 菜品销量列表
}
