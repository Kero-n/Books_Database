package com.zoro.booksDatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoro.booksDatabase.model.BooksModel;
import com.zoro.booksDatabase.model.ReviewModel;
import com.zoro.booksDatabase.repository.BooksRepository;
import com.zoro.booksDatabase.repository.ReviewRepository;
import com.zoro.booksDatabase.service.BooksService;

@Controller
public class HomeController {
	@Autowired
	private BooksRepository bookRepo;
	
	@Autowired
	private BooksService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
	    model.addAttribute("booksObj", new BooksModel());
	    return "books";
	}

	@PostMapping("/addBook")
	public String addBook(@ModelAttribute BooksModel newBook) {
	    bookRepo.save(newBook);
	    return "redirect:/";
	}
}
