package com.lanyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanyan.common.Common;
import com.lanyan.dto.BookShowDTO;
import com.lanyan.dto.ResponDTO;
import com.lanyan.service.BookShowService;

@Controller
@RequestMapping("/show")
public class ShowBookController {
	@Autowired
	private BookShowService bookShowService;
	
	@RequestMapping("/booklist")
	@ResponseBody
	public ResponDTO<List<BookShowDTO>> showList(){
		ResponDTO<List<BookShowDTO>> respon=new ResponDTO<List<BookShowDTO>>();
		respon.setCode(Common.SUCCESS.getCode());
		respon.setMessage(Common.SUCCESS.getMsg());
		respon.setData(bookShowService.getBookList());
		return respon;
	}
	
}
