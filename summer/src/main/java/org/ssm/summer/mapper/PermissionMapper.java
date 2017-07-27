package org.ssm.summer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ssm.summer.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author June
 * @since 2017-07-06
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectAllByUserId(@Param("userId") Long userId);
}