package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private MyBookService mbs;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
	   return "bookRegister";
	}
	
	@GetMapping("/availabe_book")
	public ModelAndView getAllbook() {
		List<Book> list=service.getAllBook();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("booklist");
		
		mv.addObject("book", list);
		return mv;
	//	return new ModelAndView("bookList","book",list);
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return"redirect:/availabe_book";
	}
	
	@GetMapping("/my_book")
	public String myBook( Model model) {
		List<MyBookList> list= mbs.getAllMyBook();
		model.addAttribute("book", list);
		return "Mybook";
	}
	
	
	@RequestMapping("/mylist/{id}")
	
	
	public String getMyList(@PathVariable("id") int id) {
	Book b =service.getBookById(id);
	MyBookList mbl= new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
	mbs.saveMyBook(mbl);
		return "redirect:/my_book";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id ,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book", b);
		return"bookedit";
	}
	
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/availabe_book";
		
	}
	
	
	
	
	
	
	 

}
