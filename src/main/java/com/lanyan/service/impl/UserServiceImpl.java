package com.lanyan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanyan.dto.UserDTO;
import com.lanyan.mapper.UserMapper;
import com.lanyan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
@Autowired
private UserMapper userMapper;

	public List<UserDTO> getUsers() {
		// TODO Auto-generated method stub
		System.out.println(123);
		List<UserDTO> list=userMapper.getUsers();
		return list;
	}

}
