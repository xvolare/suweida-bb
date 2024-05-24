package com.example.fastreachserve.service.business;

import result.DishNumResult;
import result.TurnoverResult;
import result.UserResult;

public interface BusinessStatisticsService {
    TurnoverResult getTurnover();

    UserResult getUser();

    DishNumResult getDishNum();
}

