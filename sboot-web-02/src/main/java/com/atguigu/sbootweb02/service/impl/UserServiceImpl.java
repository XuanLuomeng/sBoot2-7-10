package com.atguigu.sbootweb02.service.impl;

import com.atguigu.sbootweb02.bean.User;
import com.atguigu.sbootweb02.mapper.UserMapper;
import com.atguigu.sbootweb02.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
