package org.ssm.summer.util;
import java.io.PrintWriter;
import java.io.StringWriter;

/**  
 * 以文本形式输出e.printStackTrace()的内容。 *  
 * @author 
 * @date 2016年12月6日  新建  
 */
public class ExceptionUtil {
	
	public static String printStackTrace(Exception e){
		 StringWriter sw = new StringWriter(); 

         e.printStackTrace(new PrintWriter(sw, true)); 

         return sw.toString();  
	}
}
