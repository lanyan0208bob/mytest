package com.lanyan.service;

import java.util.List;

import com.lanyan.dto.BookShowDTO;

public interface BookShowService {

	/**
	 * 
	* @Title: getBookList 
	* @Description: 书单列表
	* @param @return    设定文件 
	* @return List<BookShowDTO>    返回类型 
	* @throws 
	* @author 王继波
	* @date 2018年2月27日 上午10:13:39
	 */
	
	   List<BookShowDTO> getBookList();
}
