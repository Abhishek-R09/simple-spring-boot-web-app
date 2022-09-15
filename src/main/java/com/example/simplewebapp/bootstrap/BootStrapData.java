package com.example.simplewebapp.bootstrap;

import com.example.simplewebapp.domain.Author;
import com.example.simplewebapp.domain.Book;
import com.example.simplewebapp.domain.Publisher;
import com.example.simplewebapp.repositories.AuthorRepository;
import com.example.simplewebapp.repositories.BookRepository;
import com.example.simplewebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher p1 = new Publisher("Publisher 1", "Street 1", "Mumbai", "Maharashtra", 400601);
        publisherRepository.save(p1);

        Author a1 = new Author("Abhishek", "Ramasubramanian");
        Book b1 = new Book("Book 1", "4414");
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);
        b1.setPublisher(p1);
        p1.getBooks().add(b1);
        authorRepository.save(a1);
        bookRepository.save(b1);

        Author a2 = new Author("Siddharth", "Gandhi");
        Book b2 = new Book("Book 2", "24151");
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        b2.setPublisher(p1);
        p1.getBooks().add(b2);
        authorRepository.save(a2);
        bookRepository.save(b2);

        publisherRepository.save(p1);

        System.out.println("Bootstrap...");
        System.out.println("No. of Books: " + bookRepository.count());
        System.out.println("No. of Authors: " + authorRepository.count());
        System.out.println("No. of publishers: " + publisherRepository.count());
        System.out.println("No. of books by publisher p1: " + p1.getBooks().size());
    }
}
