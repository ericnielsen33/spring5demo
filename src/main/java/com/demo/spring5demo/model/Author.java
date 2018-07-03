package com.demo.spring5demo.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastNAme;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public  Author(){

    }
    public Author(String firstName, String lastNAme) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
    }
    public Author(String firstName, String lastNAme, Set<Book> books) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNAme='" + lastNAme + '\'' +
                ", books=" + books +
                '}';
    }
}
