package com.lanyan.common;



/**
 * 
* @ClassName: SysContents 
* @Description: 系统基本设置
* @author 王继波 
* @date 2018年2月27日 下午2:30:44 
*
 */
public interface SysContents {
	/*** 系统获取json 常量 */
	final String CLIENT_JSON="CLIENT_JSON";
	/*** 系统超时时间  毫秒   超过输出logo*/
    final  int MAX_OPERATION_TIME = 4000;
    /*** 短信有效时间   15分钟*/
    final  int MSG_TIME_OUT = 15;//分钟
    /**	app一些信息    */
   	public interface app{
   		public static final String logo="assets/images/logo.png";
   	}
   	/** 用户默认签名 */
   	final String USER_SIGN_DEFAUL="爱生活，爱乐享";
     	/**  请求头   前面签名 */
     	final String PAREMENT_STRING="Versions.1.0";
     	
     	final String TOKEN_ID="tokenid";
   
}
