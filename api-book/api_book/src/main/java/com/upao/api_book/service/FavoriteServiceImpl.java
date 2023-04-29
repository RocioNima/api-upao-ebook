package com.upao.api_book.service;

import com.upao.api_book.model.Book;
import com.upao.api_book.model.FavoriteBook;
import com.upao.api_book.model.User;
import com.upao.api_book.repository.BookRepository;
import com.upao.api_book.repository.FavoriteRepository;
import com.upao.api_book.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    private FavoriteRepository favoriteRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, UserRepository userRepository, BookRepository bookRepository){
        this.favoriteRepository = favoriteRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }
    @Override
    public FavoriteBook createFavorite(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException(
                               "Libro no encontrado"
                        ));
        User user = userRepository.findById(userId).orElseThrow(()->new EntityNotFoundException(
                                "Usuario no encontrado"
                        ));
        FavoriteBook favoriteBook = new FavoriteBook(LocalDateTime.now(), LocalDateTime.now(),book,user);
        return favoriteRepository.save(favoriteBook);
    }

    @Override
    public void deleteFavoriteBook(Long id) {
        favoriteRepository.delete(getFavoriteById(id));
    }

    @Override
    public FavoriteBook getFavoriteById(Long id) {
        return favoriteRepository.findById(id).orElseThrow(()->new EntityNotFoundException(
                "La id no existe"
        ));
    }

}
