package org.ssm.summer.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    /**
     * 请求登录页面
     * @return 登录页面名称
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }
    
    /**
     * 提交登录请求
     * @param userName 用户名
     * @param password 密码
     * @return 登录成功后显示的首页名称
     */
    @RequestMapping("loginPost")
    public String loginPost(String userName, String password) {
        try {
            Subject subject = SecurityUtils.getSubject(); 
            
            //密码MD5加盐加密
            String pwd = new Md5Hash(password, SALT).toString();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            subject.login(token);
            return "index";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "login";        
    }
    
    /**
     * 退出请求
     * @return 登录页面
     */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        
        return "login";
    }
}
