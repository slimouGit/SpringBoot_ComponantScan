package slimou.springframework.spring5webapp.domain.repository;

import org.springframework.data.repository.CrudRepository;
import slimou.springframework.spring5webapp.domain.Author;

/**
 * User: salim
 * Date: 25.07.2020 15:15
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
