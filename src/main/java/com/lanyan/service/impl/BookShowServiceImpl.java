package com.lanyan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanyan.dto.BookShowDTO;
import com.lanyan.mapper.BookShowMapper;
import com.lanyan.service.BookShowService;

@Service
public class BookShowServiceImpl implements BookShowService {
	
@Autowired
private BookShowMapper bookShowMapper;
	public List<BookShowDTO> getBookList() {
		// TODO Auto-generated method stub
		return bookShowMapper.getBookList();
	}

}
