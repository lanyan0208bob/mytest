package com.lanyan.util;

import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;

import com.lanyan.common.PersistentEnum;



public class JsonUtils {
	
	private static ObjectMapper mapper = new ObjectMapper();
	/**
	 * 
	 * 把枚举转换为json String  形式 
	 * @author cj 2017年7月26日 下午7:44:44  
	 * @param obj
	 * @return
	 */
	public static String EnumsToString(PersistentEnum obj) {
		try {
			JSONObject result = new JSONObject();
			result.put(obj.getName(),obj.getDescript());
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static String serial(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	static public <T> T toObject(Class<T> clazz, String v) {
		try {
			return mapper.readValue(v, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public <T> T toObject(Class<T> clazz, String v, String dateFormat) {
		try {
			mapper.setDateFormat(new SimpleDateFormat(dateFormat));
			return mapper.readValue(v, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
