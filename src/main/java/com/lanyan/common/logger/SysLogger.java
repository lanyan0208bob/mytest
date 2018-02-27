package com.lanyan.common.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;


/**
 * 
* @ClassName: SysLogger 
* @Description: 系统日志 
* @author 王继波 
* @date 2018年2月27日 下午2:38:17 
*
 */
public class SysLogger  extends Log4JLogger {
	
	private static final long serialVersionUID = 1L;

	public final static Log SYS_LOG = new SysLogger("TEST1.0"); 
	public final static Log SYS_ERROR = new SysLogger("ERROR_CONTROLLER");
	
	public SysLogger(String name) 
	{
		super(name);
	}
	public static void main(String[] args) {
		 SysLogger.SYS_LOG.info("fer");
	}
}
