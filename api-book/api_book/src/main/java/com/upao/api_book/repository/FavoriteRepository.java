package com.upao.api_book.repository;

import com.upao.api_book.model.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteBook,Long> {
}
