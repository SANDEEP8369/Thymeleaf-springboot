package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepository repos;
	
	public void saveMyBook(MyBookList book) {
		
		repos.save(book);
		
	}
	
	public List<MyBookList>  getAllMyBook() {
		return repos.findAll();
	}
	
	public void deleteById(int id) {
		
		repos.deleteById(id);
	}

}
