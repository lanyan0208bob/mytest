package com.lanyan.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum SysHintCode implements PersistentEnum{
	/**操作成功  */
	SUCCESS("0","操作成功"),
	/**操作失败  */
	ERROR("1","出了一点小问题，请稍后重试"),
	/**请求头验证失败  */
	HEADERROR("2","请求头验证失败"),
	/**数据加密验证失败  */
	MD5ERROR("3","数据加密验证失败"),
	/**验证码错误  */
	MSGERROR("4","验证码错误"),
	/**验证码超时，请重新发送  */
	MSGTIMEERROR("5","验证码超时，请重新发送"),
	/**手机号码未存在  */
	PHONE_NOT_EXIST("6","手机号码未存在"),
	/**密码错误  */
	PSW_ERROR("7","密码错误"),
	/**手机号不存在  */
	PHONE_ERROR("8","手机号不存在"),
	/**手机号已经存在  */
	PHONE_EXIST("8","手机号已经存在"),
	/**帖子历史记录错误 */
	SHARE_LIFE_HISTROY_ERROR("9","帖子历史记录错误"),
	/**当前主题没有发布分享信息*/
	SHARE_EMPTY_ERROR("10","当前主题没有发布分享信息"),
	/**已经查看过记录*/
	SHARE_ALEATY("10","已经查看过记录"),
	/**游客观看，未登陆不记录*/
	NOT_LOGIN("11","游客观看，未登陆,不记录"),
	/**取消赞成功*/
	SHARE_GOODs_DELETE("12","取消赞成功"),
	/**参数传递错误*/
	PARAMS_ERROR("13","传递参数有误"),
	;
    
    private int index;
    
    private String name;
    
    private String descript;
    
    private static Map<String,SysHintCode> map= new LinkedHashMap<String,SysHintCode>();
    
    private static Map<String,String> valMap= new LinkedHashMap<String,String>();
    
    private static boolean inited= false;
    
    private SysHintCode(String _name,String _desc){
        index= this.ordinal();
        name= _name;
        descript= _desc;
    }
    
    /**
     * 初始化方法
     *
     */
    static{
        if(! inited){
        	SysHintCode[] ins= SysHintCode.values();
            for(int i= 0;i< ins.length;i++ ){
                map.put(ins[i].getName(),ins[i]);
                valMap.put(ins[i].getName(),ins[i].getDescript());
            }
            inited= true;
        }
    }
    public String getNameAndDes(){
        return this.name+":"+this.descript;
    }
    public String getDescript(){
        return this.descript;
    }
    
    public String getName(){
        return this.name;
    }
    
    public SysHintCode getFromName(String name){
        return map.get(name);
    }
    
    public Collection<PersistentEnum> getAllInstance(){
        List<PersistentEnum> list= new ArrayList<PersistentEnum>();
        for(SysHintCode one : map.values())
            list.add(one);
        return list;
    }
    
    public static SysHintCode getByName(String name){
        return map.get(name);
    }
    
    public static SysHintCode getByDesc(String desc){
        for(String key : valMap.keySet()){
            String _desc= valMap.get(key);
            if(_desc.equalsIgnoreCase(desc))
                return map.get(key);
        }
        return null;
    }
    
    public static Map<String,String> getValMap(){
        Map<String,String> _valMap= new LinkedHashMap<String,String>();
        _valMap.putAll(valMap);
        return _valMap;
    }
    
    public static String getDictName(){
        return "AccStatus";
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public static SysHintCode getByLongName(String longName){
        for(SysHintCode ts : map.values())
            if(ts.toString().equals(longName))
                return ts;
        return null;
    }
    
}
