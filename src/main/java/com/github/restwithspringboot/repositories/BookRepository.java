package com.github.restwithspringboot.repositories;

import com.github.restwithspringboot.model.Book;
import com.github.restwithspringboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
