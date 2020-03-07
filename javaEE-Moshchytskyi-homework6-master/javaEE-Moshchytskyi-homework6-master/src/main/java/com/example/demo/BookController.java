package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public String addBookGet() {
        return "form";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute BookEntity book, Model model) {
        model.addAttribute("book", book);
        bookService.createBook(book);
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "index";
    }

    @RequestMapping(value = "/books-list/book/{id}", method = RequestMethod.GET)
    public String getBookPathVariable(
            @PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));

        return "book-view";
    }




}
