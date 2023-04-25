package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        //通过条件构造器查询一个list集合,若没有条件,则可以设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        //实现新增用户信息
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("1234567@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId());
    }

    @Test
    public void testDelete() {
        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        /*int result = userMapper.deleteById(1650826993886937090L);
        System.out.println("result" + result);*/
        //根据map集合中所设置的条件进行删除
        //DELETE FROM user WHERE name = ? AND age = ?
        /*Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result" + result);*/
        //通过多个id实现批量删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1l, 2l, 3l);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result" + result);
    }

    @Test
    public void testUpdate() {
        //通过用户id修改用户信息
        //UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(4l);
        user.setName("李四");
        user.setEmail("lisi@qq.com");
        int result = userMapper.updateById(user);
        System.out.println("result" + result);
    }

    @Test
    public void testSelect() {
        //通过id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
        /*User user = userMapper.selectById(1L);
        System.out.println(user);*/
        //通过id批量查询用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        /*List<Long> list = Arrays.asList(1l, 2l, 3l);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);*/
        //根据map集合中的条件进行查询
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        /*Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);*/
        //无条件查询所有数据
        //SELECT id,name,age,email FROM user
        /*List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);*/
        //自定义查询
        //select id, name, age, email from user where id = ?
        Map<String, Object> map = userMapper.selectMapById(1l);
        System.out.println(map);
    }
}
