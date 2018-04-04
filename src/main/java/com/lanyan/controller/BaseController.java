package com.lanyan.controller;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.lanyan.common.SysContents;
import com.lanyan.common.SysHintCode;
import com.lanyan.util.JsonUtils;

import net.sf.json.JSONObject;

public class BaseController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired 
	private HttpSession session;
 
	public void generateJson(HttpServletResponse response,Object data,String code,String message){
        Map<String,Object> returnMap= Maps.newConcurrentMap();
        returnMap.put("code",code);
        returnMap.put("errorMessage",message);
        returnMap.put("data",data);
        try{
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtils.serial(returnMap));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
	/**
	 * 
	 * 把数据返回到前端  json 
	 * @author cj 2017年7月25日 下午5:06:11  
	 * @param data
	 * @param code SysErrorCode
	 */
	public void generateJson(Object data,SysHintCode code){
        Map<String,Object> returnMap= Maps.newConcurrentMap();
        returnMap.put("code",code.getName());
        returnMap.put("message",code.getDescript());
        if(data.getClass().equals(code.getClass())){
        	returnMap.put("data",((SysHintCode)data).getName() );
        }else{
        	returnMap.put("data",data==null?"":data);
        }
        try{
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtils.serial(returnMap));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
	public void generateJsonObj(JSONObject data){
        try{
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtils.serial(data));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
	/**
	 * 
	 * get请求不取流信息 
	 * @author cj 2017年7月25日 下午5:03:56  
	 * @param request
	 * @return
	 */
    public String getRequestBody(HttpServletRequest request){
        try{
            byte[] data= getHttpBody(request.getContentLength(),request.getInputStream());
            return new String(data);
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 
     * TODO 获取客户端传递的参数      经过了拦截器处理的参数
     * @author cj 2017年8月2日 下午2:35:13  
     * @return
     */
    public JSONObject getClientJson(){
        try{
            String requestJson =request.getAttribute(SysContents.CLIENT_JSON).toString();
            if(requestJson!=null&&!requestJson.equals("")){
            	return  JsonUtils.toObject(JSONObject.class,requestJson);
            }else{
            	return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 
     * TODO 获取客户端参数  未经过拦截器处理的参数 
     * @author cj 2017年8月2日 下午2:35:34  
     * @return
     */
    public JSONObject getRequestBody(){
        try{
            byte[] data= getHttpBody(request.getContentLength(),request.getInputStream());
            String requestJson =new String(data);
            if(requestJson!=null&&!requestJson.equals("")){
            	return  JsonUtils.toObject(JSONObject.class,requestJson);
            }else{
            	return null;
            }
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    protected byte[] getHttpBody(int length,InputStream in)
        throws IOException{
        byte[] data= null;
        if(length> 0){
            data= new byte[length];
            readFromInputStream(in,length,data);
        }
        else{
            data= readFromInputStream(in);
        }
        String str= new String(data).trim();
        return str.getBytes();
    }
    
    /**
     * 读取码流到EOF。
     *
     * @param inStream 输入码流
     * @param length 要读取的长度
     * @param data 存放码流
     * @throws IOException 
     * @throws IOException 
     * @throws IOException [参数说明]
     * @see [类、类#方法、类#成员]
     */
    public static void readFromInputStream(InputStream inStream,int length,byte[] data)
        throws IOException{
        DataInputStream in= new DataInputStream(inStream);
        //正常设置了Content-Length的
        if(length> 0){
            in.readFully(data,0,length);
        }
        else{
            throw new IllegalArgumentException("length must great than 0");
        }
    }
    
    public static byte[] readFromInputStream(InputStream inStream)
        throws IOException{
        DataInputStream in= new DataInputStream(inStream);
        //比最大限制的大小大一个
        byte[] temp= new byte[4* 1024];
        int n= in.read(temp);
        ByteArrayOutputStream bos= new ByteArrayOutputStream(100* 1024);
        while(n!= - 1){
            bos.write(temp,0,n);
            n= in.read(temp);
        }
        return bos.toByteArray();
    }
}
