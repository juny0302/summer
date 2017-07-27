package org.ssm.summer.service;

import org.ssm.summer.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author June
 * @since 2017-07-27
 */
public interface IUserService extends IService<User> {
    /**
     * 
    * @param user  User对象
    * @return User对象
     */
    User doUserLogin(User user);
}
