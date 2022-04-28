package com.handikang.service;

import com.handikang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;




@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void test(){
        userMapper.insertOne();
        //throw new NullPointerException();
    }

}
