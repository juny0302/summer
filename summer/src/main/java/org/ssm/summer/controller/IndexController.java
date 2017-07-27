package org.ssm.summer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssm.summer.entity.Permission;
import org.ssm.summer.mapper.PermissionMapper;
import org.ssm.summer.service.IPermissionService;
import org.ssm.summer.service.IUserService;

import com.baomidou.mybatisplus.mapper.Wrapper;

/** 
 * 功能: 
 * @author  June
 * @date    创建时间：2017年7月6日 上午9:59:33 
 * @version v5.1
 * @since   
 */
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IPermissionService permissionService;
    
    @RequestMapping("index")
    public String index(){
        System.out.println(userService.selectById(4L).getUserName());
        List<Permission> list = permissionService.selectAllByUserId(4L);
        
        System.out.println(list.size());
        
        return "index";
    }
}
