package com.zoro.booksDatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoro.booksDatabase.model.BooksModel;
import com.zoro.booksDatabase.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	private BooksRepository booksRepo;
	
	public List<BooksModel> listall(){
		return booksRepo.findAll();
	}
	
	public void save(BooksModel booksModel) {
		booksRepo.save(booksModel);
	}
	

}
