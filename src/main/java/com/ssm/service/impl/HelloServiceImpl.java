package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HelloServiceImpl  implements HelloService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> userList() {


        return userMapper.selectByExample(null);
    }
}
