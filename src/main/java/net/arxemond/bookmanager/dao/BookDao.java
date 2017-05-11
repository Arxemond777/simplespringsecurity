package net.arxemond.bookmanager.dao;

import net.arxemond.bookmanager.model.Book;
import org.springframework.cache.annotation.*;
import java.util.List;

public interface BookDao
{
    public void addBook(Book book);

//    @CachePut("book")
    public void updateBook(Book book);

//    @CacheEvict("book")
    public void removeBook(Long id);

//    @Cacheable("book")
    public Book getBookById(Long id);

    public List<Book> listBooks();
}
