package com.github.restwithspringboot.mapper;

import com.github.restwithspringboot.dto.BookDTO;
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.model.Book;
import com.github.restwithspringboot.model.Person;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setKey(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setLaunch_date(book.getLaunch_date());
        dto.setPrice(book.getPrice());
        dto.setTitle(book.getTitle());
        return dto;
    }

    public static Book toEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getKey());
        book.setAuthor(dto.getAuthor());
        book.setLaunch_date(dto.getLaunch_date());
        book.setPrice(dto.getPrice());
        book.setTitle(dto.getTitle());
        return book;
    }
}
