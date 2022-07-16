package org.example.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int book_id;

    @NotEmpty(message = "Поле \"Название книги\" не должно быть пустым")
    @Size(min = 2, max = 50, message = "Поле \"Название книги\" должно содержать от 2 до 50 символов.")
    private String name;

    @NotEmpty(message = "Поле \"Автор\" не должно быть пустым")
    @Size(min = 2, max = 50, message = "Поле \"Автор\" должно содержать от 2 до 50 символов.")
    private String author;

    private int age;

    public Book(int book_id, String name, String author, int age) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.age = age;
    }

    public Book(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
