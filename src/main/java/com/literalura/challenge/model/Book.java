package com.literalura.challenge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private Integer id;
    private String title;
    private List<Author> authors;
    private List<String> languages;

    public Book(Integer id, String title, List<Author> authors, List<String> languages) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
    }

    public Book(){}

    public Book(BookData book) {
        this.languages = book.languages();
        this.title = book.title();
        this.authors = book.authors().stream().map(a -> new Author(a)).collect(Collectors.toList());
        this.id = book.id();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "----LIBRO----\n"+
                "Titulo: "+title+"\n"+
                "Autor(es): \n"+authors+"\n"+
                "Idiomas: "+languages+"\n";
    }
}
