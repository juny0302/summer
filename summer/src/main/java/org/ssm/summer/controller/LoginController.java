package org.ssm.summer.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssm.summer.entity.User;
import org.ssm.summer.service.IUserService;
import org.ssm.summer.util.ExceptionUtil;

/** 
 * 功能: 
 * @author  June
 * @date    创建时间：2017年7月6日 下午4:36:46 
 * @version v5.1
 * @since   
 */
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    private static final String SALT = "jjch";
    
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("loginPost")
    public String loginPost(String userName,String password){
        try {
            Subject subject = SecurityUtils.getSubject(); 
            
            //密码MD5加盐加密
            String pwd =new Md5Hash(password,SALT).toString();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            subject.login(token);
            return "index";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "login";        
    }
    
    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        
        return "login";
    }
}
