package com.bhuvi.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
@Autowired 
BookService bookservice;
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam String query) {
        List<BookDTO> books = bookservice.searchbooks(query);
        return ResponseEntity.ok(books);
    }
}

