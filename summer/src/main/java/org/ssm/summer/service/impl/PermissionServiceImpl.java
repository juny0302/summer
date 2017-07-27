package org.ssm.summer.service.impl;

import org.ssm.summer.entity.Permission;
import org.ssm.summer.mapper.PermissionMapper;
import org.ssm.summer.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    
    @Cacheable(value = "permissionCache", key = "#userId")
    @Override
    public List<Permission> selectAllByUserId(Long userId) {
        return baseMapper.selectAllByUserId(userId);
    }
}
