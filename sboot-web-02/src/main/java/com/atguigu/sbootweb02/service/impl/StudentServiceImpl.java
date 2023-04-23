package com.atguigu.sbootweb02.service.impl;

import com.atguigu.sbootweb02.bean.Student;
import com.atguigu.sbootweb02.mapper.StudentMapper;
import com.atguigu.sbootweb02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer id){
        Student student = studentMapper.getStudent(1);
        return student;
    }
}
