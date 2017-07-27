package org.ssm.summer.service.impl;

import org.ssm.summer.entity.Log;
import org.ssm.summer.mapper.LogMapper;
import org.ssm.summer.service.ILogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author June
 * @since 2017-07-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {
	
}
