package org.ssm.summer.service;

import org.ssm.summer.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author June
 * @since 2017-07-06
 */
public interface IUserService extends IService<User> {
	User doUserLogin(User user);
}
