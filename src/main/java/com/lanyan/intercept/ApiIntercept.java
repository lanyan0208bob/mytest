package com.lanyan.intercept;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lanyan.common.SysContents;
import com.lanyan.common.SysHintCode;
import com.lanyan.common.logger.SysLogger;
import com.lanyan.util.JsonUtils;
import com.lanyan.util.MD5Util;
import com.lanyan.util.StringUtils;

public class ApiIntercept implements HandlerInterceptor{
	/** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */  
//	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}
	  /** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行
     * ，也就是说在这个方法中你可以对ModelAndView进行操 
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，
     * 这跟Struts2里面的拦截器的执行过程有点像， 
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，
     * Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor 
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，
     * 要在Interceptor之后调用的内容都写在调用invoke方法之后。 
     */  
//	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
			if (!request.getMethod().toString().equals("OPTIONS")){
				long startTime = (Long)request.getAttribute("startTime");  
		        long endTime = System.currentTimeMillis();  
		        long executeTime = endTime - startTime;  
		        if(executeTime>SysContents.MAX_OPERATION_TIME){
		        	SysLogger.SYS_LOG.info("[" + request.getRequestURL() + "] 请求耗时：executeTime : " + executeTime + "ms");
		        }
			}
		  	
	}
	  /** 
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。 
     */  
//	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
			if (request.getMethod().toString().equals("OPTIONS") ){
			    return true;
			}
			String url =request.getRequestURL().toString();
			String ip =getRemortIP(request);
			
			long startTime = System.currentTimeMillis();  
	        request.setAttribute("startTime", startTime);  
			JSONObject js = new JSONObject();
			InputStream in = request.getInputStream();
			
			BufferedReader is = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = is.readLine()) != null) {
				buffer.append(line);
			}
			
			if(!StringUtils.isBlank(buffer.toString())){
				js = JSONObject.fromObject(buffer.toString());
			}
			
			
			//md5前端秘钥
			Object tokin =js.get(SysContents.TOKEN_ID);
			
			if(tokin==null){
				SysLogger.SYS_LOG.info(ip+"访问"+url+SysHintCode.HEADERROR.getDescript());
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(JsonUtils.EnumsToString(SysHintCode.HEADERROR));
				return false;
			}
			String sys_param=tokin.toString();
			js.remove(SysContents.TOKEN_ID);
			//md5数据加密验证
			String md5par=SysContents.PAREMENT_STRING+js.toString() ;
			md5par=md5par.replace("\"", "");
			
			String md5 = MD5Util.GetMD5Code(md5par);
			if (!md5.equals(sys_param)) {
				SysLogger.SYS_LOG.info(ip+"访问"+url+SysHintCode.MD5ERROR.getDescript());
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(JsonUtils.EnumsToString(SysHintCode.MD5ERROR));
				return false;
			}
			request.setAttribute(SysContents.CLIENT_JSON, js);
	        return true;
	}
	public String getRemortIP(HttpServletRequest request) {
	  if (request.getHeader("x-forwarded-for") == null) {
	   return request.getRemoteAddr();
	  }
	  return request.getHeader("x-forwarded-for");
	}
}
