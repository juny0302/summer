package org.ssm.summer.service;

import java.util.List;

import org.ssm.summer.entity.Permission;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author June
 * @since 2017-07-06
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> selectAllByUserId(Long userId);

}
