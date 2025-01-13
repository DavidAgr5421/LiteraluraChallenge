package com.literalura.challenge.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private long download_count;
    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @ElementCollection
    @CollectionTable(name = "book_language", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language")
    private List<String> languages;

    public Book(Long id, String title, long download_count, List<Author> authors, List<String> languages) {
        this.id = id;
        this.title = title;
        this.download_count = download_count;
        this.authors = authors;
        this.languages = languages;
    }

    public Book(){}

    public Book(BookData book) {
        this.languages = book.languages();
        this.title = book.title();
        this.download_count = book.download_count();
        this.authors = book.authors().stream().map(a -> new Author(a)).collect(Collectors.toList());
        this.id = book.id();
    }

    public long getDownload_count() {
        return download_count;
    }

    public void setDownload_count(long download_count) {
        this.download_count = download_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                "Idiomas: "+languages+"\n"+
                "Descargas: "+download_count+"\n";
    }
}
