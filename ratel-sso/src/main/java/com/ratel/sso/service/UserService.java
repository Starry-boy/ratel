package com.ratel.sso.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.sso.domain.User;

/**
 * @author com.ratel
 * @date 2020/3/16
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);
}
