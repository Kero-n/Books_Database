package com.zoro.booksDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoro.booksDatabase.model.BooksModel;

@Repository
public interface BooksRepository  extends JpaRepository<BooksModel,Long>{

}
