package org.ssm.test;

import org.apache.shiro.crypto.hash.Md5Hash;

/** 
 * 功能: 
 * @author  June
 * @date    创建时间：2017年7月6日 下午2:48:21 
 * @version v5.1
 * @since   
 */
public class AppTest {
    
    public static void main(String[] args) {
        //System.out.println(StringUtils.isBlank("1"));
        System.out.println(new Md5Hash("111111","jjch").toString());
        
    }
}
