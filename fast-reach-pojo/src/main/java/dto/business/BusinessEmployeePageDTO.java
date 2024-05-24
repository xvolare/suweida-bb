package dto.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessEmployeePageDTO {
    private String name;//名字
    private Integer Page; // 当前页码
    private Integer pageSize;     // 每页显示的记录数
}