package com.zoro.booksDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zoro.booksDatabase.model.BooksModel;
import com.zoro.booksDatabase.service.BooksService;



@SpringBootApplication
public class BooksDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksDatabaseApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(BooksService booksService) {
		return args -> {
	        if (booksService.listall().isEmpty()) {
	            booksService.save(new BooksModel(1, "Game Of Thrones", "George R. R. Martin", 18.00));
	            booksService.save(new BooksModel(2, "One Piece Manga", "Eichiro Oda", 15.00));
	            booksService.save(new BooksModel(3, "Dragon Ball Manga", "Toriyama", 12.00));
		}
	};

   }

}
