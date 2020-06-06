package com.question.service.impl;

import com.question.entity.User;
import com.question.mapper.UserMapper;
import com.question.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ye
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByToken(String token) {
        User user = userMapper.findByToken(token);
        return user;
    }

    @Override
    public User findByAccountId(String creator) {
        User user = userMapper.findByAccountId(creator);
        return user;
    }
}
