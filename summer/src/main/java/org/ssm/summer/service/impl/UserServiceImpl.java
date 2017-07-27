package org.ssm.summer.service.impl;

import org.ssm.summer.entity.User;
import org.ssm.summer.mapper.UserMapper;
import org.ssm.summer.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author June
 * @since 2017-07-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User doUserLogin(User user) {        
        User result = userMapper.selectOne(user);
        return result;
    }
	
}
