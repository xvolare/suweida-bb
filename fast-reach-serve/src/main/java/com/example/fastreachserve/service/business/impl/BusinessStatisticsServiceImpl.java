package com.example.fastreachserve.service.business.impl;

import com.example.fastreachserve.mapper.business.BusinessStatisticsMapper;
import com.example.fastreachserve.service.business.BusinessStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.DishNumResult;
import result.TurnoverResult;
import result.UserResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessStatisticsServiceImpl implements BusinessStatisticsService {
    @Autowired
    BusinessStatisticsMapper businessStatisticsMapper;
    private static final Logger logger = LoggerFactory.getLogger(BusinessStatisticsServiceImpl.class);

    @Override
    public TurnoverResult getTurnover() {
        List<String> allTotalPrice = businessStatisticsMapper.getAllTotalPrice();
        List<String> allOrderDates = businessStatisticsMapper.getAllOrderDates();

        // 如果你的系统中订单数据和日期是一一对应的，则直接使用这些列表创建 TurnoverResult
        // 注意：如果一天中有多个订单，你需要先对数据进行处理，按日期汇总所有订单的总价格
        Map<String, Double> turnoverMap = new HashMap<>();
        for (int i = 0; i < allOrderDates.size(); i++) {
            String date = allOrderDates.get(i);
            double price = Double.parseDouble(allTotalPrice.get(i).replace("￥", ""));
            turnoverMap.merge(date, price, Double::sum); // 按日期合并价格
        }

        // 将Map转换为两个列表，一个用于日期，另一个用于营业额
        List<String> dateList = new ArrayList<>(turnoverMap.keySet());
        List<String> turnoverList = new ArrayList<>();
        dateList.forEach(date -> turnoverList.add(String.format("%.2f", turnoverMap.get(date))));

        // 打印结果到控制台
        logger.info("Turnover data: {}", turnoverMap);

        // 创建并返回TurnoverResult对象
        return new TurnoverResult(dateList, turnoverList);
    }

    @Override
    public UserResult getUser() {
        List<String> allOrderDates =  businessStatisticsMapper.getAllOrderDates();

        // 使用Map来存储每个日期的订单数
        Map<String, Integer> dateOrderCountMap = new HashMap<>();

        // 遍历日期，填充Map
        for (String orderDate : allOrderDates) {
            dateOrderCountMap.merge(orderDate, 1, Integer::sum); // 合并键值，每次遇到相同日期就加1
        }

        // 准备返回结果
        List<String> dateList = new ArrayList<>();
        List<Integer> orderNumList = new ArrayList<>();

        // 排序日期并填充结果
        dateOrderCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    dateList.add(entry.getKey());
                    orderNumList.add(entry.getValue());
                });

        // 打印结果到控制台
        logger.info("User data: Date List - {}, Order Numbers - {}", dateList, orderNumList);


        return new UserResult(dateList, orderNumList);
    }

    @Override
    public DishNumResult getDishNum() {
        List<String> allDishNames = businessStatisticsMapper.getAllDishNames();
        List<String> allOrderedDishes = businessStatisticsMapper.getAllOrderedDishes();

        // 用于存储每个菜品ID对应的订单次数
        Map<Integer, Integer> dishCountMap = new HashMap<>();

        // 解析每个订单中的菜品ID并统计每个菜品的销售次数
        allOrderedDishes.forEach(ordered -> {
            // 去除字符串的"["和"]"，然后分割
            String[] dishes = ordered.replace("[", "").replace("]", "").split(", ");
            for (String dish : dishes) {
                Integer dishId = Integer.parseInt(dish);
                dishCountMap.merge(dishId, 1, Integer::sum);
            }
        });

        // 准备返回结果中的名称列表和数量列表
        List<String> nameList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();

        // 根据菜品ID匹配菜品名称，并填充返回结果
        allDishNames.forEach(name -> {
            // 假设我们也从Mapper获取菜品ID对应的列表
            Integer dishId = businessStatisticsMapper.getDishIdByName(name); // 需要在Mapper中实现这个方法
            if (dishCountMap.containsKey(dishId)) {
                nameList.add(name);
                numberList.add(dishCountMap.get(dishId));
            }
        });

        // 打印结果到控制台
        logger.info("Dish numbers data: Dish Names - {}, Numbers - {}", nameList, numberList);


        return new DishNumResult(nameList, numberList);
    }
}

