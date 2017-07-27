package org.ssm.summer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssm.summer.entity.Permission;
import org.ssm.summer.service.IPermissionService;
import org.ssm.summer.service.IUserService;

/** 
 * 功能: 
 * @author  June
 * @date    创建时间：2017年7月6日 上午9:59:33 
 * @version v5.1
 * @since   
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IPermissionService permissionService;
    private final Long userId = 4L;
    
    /**
     * 默认首页
     * @return 首页文件名称
     */
    @RequestMapping("index")
    public String index() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(userService.selectById(userId).getUserName());
        }

        List<Permission> list = permissionService.selectAllByUserId(userId);
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(null, list.size());
        }
        
        return "index";
    }
}
