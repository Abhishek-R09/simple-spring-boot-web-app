package com.example.simplewebapp.repositories;

import com.example.simplewebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
