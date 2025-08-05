package com.zoro.booksDatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zoro.booksDatabase.model.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long>{
    List<ReviewModel> findByBookId(Long bookId);

}
