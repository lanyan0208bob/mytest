package com.lanyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lanyan.common.Common;
import com.lanyan.dto.ResponDTO;
import com.lanyan.dto.UserDTO;
import com.lanyan.service.UserService;

@Controller
public  class TestController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/test2")
	@ResponseBody
	public String test(){
		ResponDTO<List<UserDTO>> respon=new ResponDTO<List<UserDTO>>();
		respon.setCode(Common.SUCCESS.getCode());
		respon.setMessage(Common.SUCCESS.getMsg());
		respon.setData(userService.getUsers());
		Gson gson=new Gson();
		String json=gson.toJson(respon);
		System.out.println(json);
		return json;
	}
	
	
	@RequestMapping(value="/test")
	@ResponseBody
	public ResponDTO<List<UserDTO>>  test2(){
		ResponDTO<List<UserDTO>> respon=new ResponDTO<List<UserDTO>>();
		respon.setCode(Common.SUCCESS.getCode());
		respon.setMessage(Common.SUCCESS.getMsg());
		respon.setData(userService.getUsers());
		Gson gson=new Gson();
		String json=gson.toJson(respon);
		System.out.println(json);
		return respon;
	}

}
