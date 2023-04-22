package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository boo;
	
	public void save(Book b) {
		boo.save(b);
		
	}
	
	public List<Book> getAllBook(){
		return boo.findAll();
	}
	
	public Book getBookById(int id) {
		
		return boo.findById(id).get();
	}
	
	public void deleteById(int id) {
		
		boo.deleteById(id);
	}
	

}
