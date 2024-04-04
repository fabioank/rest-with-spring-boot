package com.github.restwithspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@JsonPropertyOrder({"id", "author", "launch_date", "price", "title"})
public class BookDTO extends RepresentationModel<BookDTO> {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;
    private String author;
    private Date launch_date;
    private float price;
    private String title;

    public BookDTO (){

    }


    public BookDTO(Long key, String author, Date launch_date, float price, String title) {
        this.key = key;
        this.author = author;
        this.launch_date = launch_date;
        this.price = price;
        this.title = title;
    }
    @JsonProperty("id")
    public Long getKey() {
        return key;
    }
    @JsonProperty("id")
    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
