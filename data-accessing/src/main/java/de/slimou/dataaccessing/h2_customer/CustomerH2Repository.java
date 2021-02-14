package de.slimou.dataaccessing.h2_customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerH2Repository extends CrudRepository<CustomerH2, Long> {

    List<CustomerH2> findByLastName(String lastName);

    CustomerH2 findById(long id);

    void deleteById(Long id);

    long count();
}
