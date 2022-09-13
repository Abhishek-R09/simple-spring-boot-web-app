package com.example.simplewebapp.repositories;

import com.example.simplewebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
