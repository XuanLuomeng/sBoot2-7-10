package com.atguigu.sbootweb02.service.impl;

import com.atguigu.sbootweb02.bean.City;
import com.atguigu.sbootweb02.mapper.CityMapper;
import com.atguigu.sbootweb02.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    @Override
    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    @Override
    public void saveCity(City city){
        cityMapper.insert(city);
    }
}
