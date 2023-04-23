package com.atguigu.sbootweb02.service;

import com.atguigu.sbootweb02.bean.City;

public interface CityService {
    City getById(Long id);

    void saveCity(City city);
}
