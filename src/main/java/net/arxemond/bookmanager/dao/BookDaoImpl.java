package net.arxemond.bookmanager.dao;

import net.arxemond.bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao
{
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory; // Сессия для работы с БД

    public void setSessionFactory(SessionFactory sessionFactory) { // Само внедрение
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession(); // Получаем текущие сессию
        session.persist(book);

        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);

        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeBook(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Long(id));

        if (book != null) // Если существует
            session.delete(book);

        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Book getBookById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Long(id));

        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked") // Список предупреждений, уровнеь отслеживания
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list(); // select * from book и делаем list из результата

        for (Book book : bookList)
            logger.info("Book list: " + book);

        return bookList;
    }
}
