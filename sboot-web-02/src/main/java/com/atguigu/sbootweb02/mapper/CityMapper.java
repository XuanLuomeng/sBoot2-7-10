package com.atguigu.sbootweb02.mapper;

import com.atguigu.sbootweb02.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * useGeneratedKeys返回自增内容
 * keyProperty返回自增的列名
 */
//@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    @Insert("insert into city(`name`, `state`, `country`) values (#{name}, #{state}, #{country});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);
}
