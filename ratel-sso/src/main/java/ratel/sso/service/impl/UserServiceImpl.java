package ratel.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ratel.sso.domain.User;
import ratel.sso.mapper.UserMapper;
import ratel.sso.service.UserService;

/**
 * @author ratel
 * @date 2020/3/16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public User getByUsername(String username) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
    }
}
