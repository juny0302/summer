package org.ssm.summer.shiro.realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssm.summer.entity.User;
import org.ssm.summer.service.IUserService;

/**
 * 
 * @author Administrator
 *
 */
@Component
public class ShiroDbRealm extends AuthorizingRealm { 
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);
    @Autowired  
    private IUserService userService;  
    public static final String SESSION_USER_KEY = "summer";  
  
    /** 
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {  
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(ShiroDbRealm.SESSION_USER_KEY);  
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(user.getUserName());
        }
        return info;  
    }  
  
    /** 
     * 认证回调函数，登录信息和用户验证信息验证 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {  
        // 把token转换成User对象  
        User userLogin = tokenToUser((UsernamePasswordToken) authcToken);  
        // 验证用户是否可以登录  
        User ui = userService.doUserLogin(userLogin);  
        if (ui == null) {
            throw new UnknownAccountException(); 
        }  
        // 设置session  
        Session session = SecurityUtils.getSubject().getSession();  
        session.setAttribute(ShiroDbRealm.SESSION_USER_KEY, ui);   
        //当前 Realm 的 name  
        String realmName = this.getName();  
        //登陆的主要信息: 可以是一个实体类的对象, 但该实体类的对象一定是根据 token 的 username 查询得到的.  
//      Object principal = ui.getUsername();  
        Object principal = authcToken.getPrincipal();  
        return new SimpleAuthenticationInfo(principal, userLogin.getPassword(), realmName);  
    }  
    /**
     * 
     * @param authcToken UsernamePasswordToken对象
     * @return 一个User对象
     */
    private User tokenToUser(UsernamePasswordToken authcToken) {  
        User user = new User();  
        user.setAccount(authcToken.getUsername());  
        user.setPassword(String.valueOf(authcToken.getPassword()));  
        return user;  
    }  
  
    //一定要写getset方法  
    public IUserService getUserService() {  
        return userService;  
    }  
  
    public void setUserService(IUserService userService) {  
        this.userService = userService;  
    }  
}
