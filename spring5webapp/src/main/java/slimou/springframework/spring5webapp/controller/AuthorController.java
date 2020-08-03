package slimou.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import slimou.springframework.spring5webapp.domain.repository.AuthorRepository;

/**
 * User: salim
 * Date: 25.07.2020 18:15
 */
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/author-list";
    }

    @RequestMapping("/author-books")
    public String getAuthorBooks(@RequestParam("id") Long id, Model model) {

        model.addAttribute("author_firstname", authorRepository.findById(id).get().getFirstname());
        model.addAttribute("author_lastname", authorRepository.findById(id).get().getLastname());
        model.addAttribute("author_books", authorRepository.findById(id).get().getBooks());

        return "authors/author-books";
    }
}
