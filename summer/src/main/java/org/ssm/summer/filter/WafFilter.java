package org.ssm.summer.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.ssm.summer.util.ExceptionUtil;

import com.baomidou.kisso.common.util.HttpUtil;
import com.baomidou.kisso.web.waf.request.WafRequestWrapper;

/**
 * Waf防火墙过滤器
 * 
 * @author  June
 * @version v1.0
 * @since
 */
public class WafFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger("WafFilter");

	//非过滤地址
	private static String overUrl = null;

	//开启XSS脚本过滤
	private static boolean filterXss = true;

	//开启SQL注入过滤
	private static boolean filterSql = true;


	/**
	 * 初始化
	 * @param config FilterConfig对象
	 * @throws ServletException servlet异常
	 */	
	public void init(FilterConfig config) throws ServletException {
		//读取Web.xml配置地址
		overUrl = config.getInitParameter("over.url");

		filterXss = getParamConfig(config.getInitParameter("filter_xss"));
		filterSql = getParamConfig(config.getInitParameter("filter_sql_injection"));
	}


	/**
	 * @param request ServletRequest 
	 * @param response ServletResponse   
	 * @param chain FilterChain
	 * @throws  IOException IOException 
	 * @throws  ServletException ServletException      * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse res = (HttpServletResponse) response;

		boolean isOver = HttpUtil.inContainURL(req, overUrl);

		/** 非拦截URL、直接通过. */
		if (!isOver) {
			try {
				//Request请求XSS过滤
				chain.doFilter(new WafRequestWrapper(req, filterXss, filterSql), response);
			} catch (Exception e) {
				//logger.severe(" wafxx.jar WafFilter exception , requestURL: " + req.getRequestURL());
			    LOGGER.severe(ExceptionUtil.printStackTrace(e));
			}
			return;
		}

		chain.doFilter(request, response);
	}


	/**
	 * 
	 */
	public void destroy() {
		LOGGER.warning(" WafFilter destroy .");
	}




	 /**
     * @Description 获取参数配置
     * @param value 配置参数
     * @return 未配置返回 True
     */
	private boolean getParamConfig(String value) {
		if (value == null || "".equals(value.trim())) {
			//未配置默认 True
			return true;
		}
		return new Boolean(value);
	}
}
