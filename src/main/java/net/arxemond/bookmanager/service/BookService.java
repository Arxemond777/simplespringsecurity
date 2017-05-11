package net.arxemond.bookmanager.service;

import net.arxemond.bookmanager.model.Book;
import org.springframework.cache.annotation.*;
import java.util.List;

public interface BookService
{
    public void addBook(Book book);

    public void updateBook(Long id, Book book);

    public void removeBook(Long id);

    public Book getBookById(Long id);

    public List<Book> listBooks();
}
