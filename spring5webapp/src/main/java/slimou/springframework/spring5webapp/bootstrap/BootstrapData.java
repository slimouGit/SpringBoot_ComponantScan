package slimou.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import slimou.springframework.spring5webapp.domain.Author;
import slimou.springframework.spring5webapp.domain.Book;
import slimou.springframework.spring5webapp.domain.Publisher;
import slimou.springframework.spring5webapp.domain.repository.AuthorRepository;
import slimou.springframework.spring5webapp.domain.repository.BookRepository;
import slimou.springframework.spring5webapp.domain.repository.PublisherRepository;

/**
 * User: salim
 * Date: 25.07.2020 15:56
 */

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("BookStore Publisher");
        publisher.setCity("Frankfurt");
        publisher.setState("Hessen");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());


        Author celine = new Author("Louis-Ferdinand", "Celine");
        Book reise = new Book("Reise ans Ende der Nacht", "42");
        celine.getBooks().add(reise);
        reise.getAuthors().add(celine);

        reise.setPublisher(publisher);
        publisher.getBooks().add(reise);

        authorRepository.save(celine);
        bookRepository.save(reise);
        publisherRepository.save(publisher);


        Author dostojewski = new Author("Fjodor", "Dostojewski");
        Book schuld = new Book("Schuld und Sühne", "225523");
        dostojewski.getBooks().add(schuld);
        schuld.getAuthors().add(dostojewski);

        schuld.setPublisher(publisher);
        publisher.getBooks().add(schuld);

        authorRepository.save(dostojewski);
        bookRepository.save(schuld);
        publisherRepository.save(publisher);

        System.out.println("number of books " + bookRepository.count());
        System.out.println("publisher book size " + publisher.getBooks().size());

        for (Book book : bookRepository.findAll()) {
            System.out.println("book " + book.getTitle());
        }
    }

}
