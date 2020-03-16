package ratel.sso.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ratel.sso.domain.User;

/**
 * @author ratel
 * @date 2020/3/16
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);
}
