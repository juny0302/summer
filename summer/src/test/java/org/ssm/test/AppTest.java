package org.ssm.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        //System.out.println(new Md5Hash("111111","jjch").toString());
        //System.out.println(genSql());
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println((System.currentTimeMillis()/1000 - Integer.valueOf(1501892368)));
    }
    
    /**
     * 生成统计sql 
     * @return
     */
    private static String genSql(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 4, 31, 0,0,0);
       
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 61; i++) {
            calendar.add(Calendar.DATE, 1);            
            String tableName = "wifi_authlist_" + sdf.format(calendar.getTime());
            
            sb.append(String.format("SELECT token,mac from %s  WHERE  LENGTH(token) =11 GROUP BY token,mac UNION ALL \n",tableName));
        }
        
        return sb.toString();
    }
}
