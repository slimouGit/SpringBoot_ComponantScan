package slimou.springframework.spring5webapp.domain.repository;

import org.springframework.data.repository.CrudRepository;
import slimou.springframework.spring5webapp.domain.Publisher;

/**
 * User: salim
 * Date: 25.07.2020 17:36
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
