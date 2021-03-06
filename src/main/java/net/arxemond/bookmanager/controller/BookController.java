package net.arxemond.bookmanager.controller;

import net.arxemond.bookmanager.model.Book;
import net.arxemond.bookmanager.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController
{
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService") // Решает неоднозначность бина
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books_diagram", method = RequestMethod.GET)
    public ModelAndView listBooksDiagram(/*Model model*/) {
        /*model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks()); // Вызываем метод (listBooks) через bookService
        System.out.println(1);*/

        return new ModelAndView("booksDiagram");
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView listBooks(Model model) {
        System.out.println(2);
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks()); // Вызываем метод (listBooks) через bookService

        return new ModelAndView("books");
    }

    /**
     * @ModelAttribute - http://www.seostella.com/ru/article/2012/04/24/modelattribute-i-spring-mvc.html
     * Прокидывает атрибут book
     */
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        System.out.println(book);

        if (book.getId() == null) // Если id == 0 - то add. TODO сменил тип id с int на Long, поэтому терь если null
            this.bookService.addBook(book);
         else  // Иначе update
            this.bookService.updateBook(book.getId(), book);

        return "redirect:/books/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        this.bookService.removeBook(id);

        return "redirect:/books/books";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping("/bookdata/{id}")
    public String bookData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }
}
