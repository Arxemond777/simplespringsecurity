package net.arxemond.bookmanager.service;

import net.arxemond.bookmanager.dao.BookDao;
import net.arxemond.bookmanager.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.*;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
//    @Cacheable(value = "book", unless = "#book.getId() == null")
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
//    @CachePut(value = "book")
//    @CachePut(value = "book", key = "#id") // CachePut - Не перезаписывает
    @CacheEvict(value = "book", allEntries = true)
    public void updateBook(Long id, Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    @CacheEvict(value = "book")
    public void removeBook(Long id) {
        this.bookDao.removeBook(id);
    }

    @Override
    @Transactional
    @Cacheable(value = "book")
    public Book getBookById(Long id) {
        logger.info("get book by id = " + id);

        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }
}
