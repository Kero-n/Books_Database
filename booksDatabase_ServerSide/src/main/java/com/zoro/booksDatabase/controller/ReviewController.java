package com.zoro.booksDatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoro.booksDatabase.model.BooksModel;
import com.zoro.booksDatabase.model.ReviewModel;
import com.zoro.booksDatabase.repository.BooksRepository;
import com.zoro.booksDatabase.repository.ReviewRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class ReviewController {
	@Autowired
	private BooksRepository bookRepo;
	
    @Autowired
    private ReviewRepository reviewRepo;
	
	@GetMapping("/viewBooks")
	public List<BooksModel> viewBooks() {
		return bookRepo.findAll();
	}
	
	@PostMapping("/addReview/{bookId}")
	@CrossOrigin(origins = "http://localhost:4200")
    public ReviewModel addReview(@PathVariable Long bookId, @RequestBody ReviewModel review) {
		reviewRepo.save(review);
		return review;
	}
	

	
	@GetMapping("/viewReviews/{bookId}")
	public List<ReviewModel> viewReviews(@PathVariable Long bookId) {
	    List<ReviewModel> reviews = reviewRepo.findByBookId(bookId);
	    return reviews;
	}


    
}
