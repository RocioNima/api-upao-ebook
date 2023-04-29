package com.upao.api_book.service;

import com.upao.api_book.model.Book;
import com.upao.api_book.model.FavoriteBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {
    FavoriteBook createFavorite(Long bookId, Long userId);
    void deleteFavoriteBook(Long id);
    FavoriteBook getFavoriteById(Long id);
}
