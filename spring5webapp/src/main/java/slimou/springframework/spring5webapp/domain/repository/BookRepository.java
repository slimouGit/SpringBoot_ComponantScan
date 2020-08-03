package slimou.springframework.spring5webapp.domain.repository;

import org.springframework.data.repository.CrudRepository;
import slimou.springframework.spring5webapp.domain.Book;

/**
 * User: salim
 * Date: 25.07.2020 15:18
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
