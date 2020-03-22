package com.ratel.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.ratel.sso.domain.User;
import com.ratel.sso.mapper.UserMapper;
import com.ratel.sso.service.UserService;

/**
 * @author com.ratel
 * @date 2020/3/16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public User getByUsername(String username) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
    }
}
