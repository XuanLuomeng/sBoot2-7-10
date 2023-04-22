package com.atguigu.sbootweb02.service;

import com.atguigu.sbootweb02.bean.Student;
import com.atguigu.sbootweb02.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student getStudentById(Integer id){
        Student student = studentMapper.getStudent(1);
        return student;
    }
}
