package slimou.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import slimou.springframework.spring5webapp.domain.Author;
import slimou.springframework.spring5webapp.domain.Book;
import slimou.springframework.spring5webapp.domain.repository.AuthorRepository;
import slimou.springframework.spring5webapp.domain.repository.BookRepository;

/**
 * User: salim
 * Date: 25.07.2020 15:56
 */

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author celine = new Author("Louis-Ferdinand", "Celine");
        Book reise = new Book("Reise ans Ende der Nacht", "42");
        celine.getBooks().add(reise);
        reise.getAuthors().add(celine);
        authorRepository.save(celine);
        bookRepository.save(reise);

        Author dostojewski = new Author("Fjodor", "Dostojewski");
        Book schuld = new Book("Schuld und Sühne", "225523");
        dostojewski.getBooks().add(schuld);
        schuld.getAuthors().add(dostojewski);
        authorRepository.save(dostojewski);
        bookRepository.save(schuld);

        System.out.println("Started in Bootstrap");
        System.out.println("number of books " + bookRepository.count());

        for (Book book : bookRepository.findAll()) {
            System.out.println("book " + book.getTitle());
        }
    }

}
