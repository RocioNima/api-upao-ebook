package com.upao.api_book.controller;

import com.upao.api_book.model.FavoriteBook;
import com.upao.api_book.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

        public FavoriteController(FavoriteService favoriteService){
            this.favoriteService = favoriteService;
        }

        @PostMapping
            public ResponseEntity<FavoriteBook> addFavorite(@RequestParam Long bookId,
                                                            @RequestParam Long userId){
            FavoriteBook favoriteBook1 = favoriteService.createFavorite(bookId,userId);
            return ResponseEntity.ok(favoriteBook1);
        }

        @DeleteMapping("/delete/{id}")
            public void deleteFavorite(@PathVariable Long id){
                favoriteService.deleteFavoriteBook(id);
        }


}
