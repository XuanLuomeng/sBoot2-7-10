package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
        //查询总记录数
        //SELECT COUNT( * ) AS total FROM user
        long count = userService.count();
        System.out.println("count:" + count);
    }

    @Test
    public void testSave() {
        //批量添加（是service通过循环调用单个sql语句多次进行添加）
        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("hello" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }
}
