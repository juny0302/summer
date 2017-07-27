package org.ssm.summer.service.impl;

import org.ssm.summer.entity.Config;
import org.ssm.summer.mapper.ConfigMapper;
import org.ssm.summer.service.IConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {
	
}
