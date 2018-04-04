package com.lanyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyan.common.SysHintCode;

import net.sf.json.JSONObject;

@Controller  
@CrossOrigin(origins= "*",maxAge= 3600)
@RequestMapping("/api/")
public class InitController extends BaseController{

	
	@RequestMapping(value = "index",method ={RequestMethod.POST,RequestMethod.GET} )
	@ResponseBody
    public void v(String curTime ) throws Exception {
		JSONObject requestJson= this.getClientJson();
//		requestJson.put("appname", ConfigUtils.getConfig("appname"));
//		requestJson.put("logo", SysConfig.app.logo);
        this.generateJson(requestJson,SysHintCode.SUCCESS);
    }
	@RequestMapping(value = "test",method ={RequestMethod.POST,RequestMethod.GET} )
	@ResponseBody
    public void test(String curTime ) throws Exception {
		JSONObject requestJson= this.getClientJson();
        this.generateJson(requestJson,SysHintCode.SUCCESS);
    }
	

	
	
	
	

}
