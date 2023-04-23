package com.atguigu.sbootweb02.mapper;

import com.atguigu.sbootweb02.bean.Student;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface StudentMapper {
    public Student getStudent(Integer id);
}
