package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private int id;
    private String name;
    private String price;//后端处理，防止精度丢失，所以数据库中存Stirng
    private String description;
    private String status;//0是停售，1是正常售卖
    private int sum;//售卖数量
    private String image;//图片路径
}
