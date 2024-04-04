package com.github.restwithspringboot.services;

import com.github.restwithspringboot.controller.BookController;
import com.github.restwithspringboot.controller.PersonController;
import com.github.restwithspringboot.dto.BookDTO;
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.exceptions.RequiredObjectIsNull;
import com.github.restwithspringboot.exceptions.ResourceNotFoundException;
import com.github.restwithspringboot.mapper.BookMapper;
import com.github.restwithspringboot.mapper.PersonMapper;
import com.github.restwithspringboot.mapper.PersonMapperV2;
import com.github.restwithspringboot.model.Book;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.BookRepository;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> findAll() {
        List<Book> books = repository.findAll();

        List<BookDTO> listBooks = books.stream()
                .map(BookMapper::toDTO)
                .toList();

        listBooks.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return listBooks;
    }

    public BookDTO findById(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        BookDTO dto = BookMapper.toDTO(book);
        dto.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return dto;
    }

    public BookDTO create (BookDTO bookDTO) {

        if(bookDTO == null) throw new RequiredObjectIsNull();

        Book book = BookMapper.toEntity(bookDTO);
        Book savedBook = repository.save(book);
        BookDTO dto = BookMapper.toDTO(savedBook);
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }

    public BookDTO update (BookDTO BookDTO){

        if(BookDTO == null) throw new RequiredObjectIsNull();

        Book book = repository.findById(BookDTO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        book.setAuthor(BookDTO.getAuthor());
        book.setPrice(BookDTO.getPrice());
        book.setPrice(BookDTO.getPrice());
        book.setTitle(BookDTO.getTitle());

        Book bookUpdated = repository.save(book);
        BookDTO dto = BookMapper.toDTO(bookUpdated);

        dto.add(linkTo(methodOn(BookController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public void delete(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(book);
    }
}
