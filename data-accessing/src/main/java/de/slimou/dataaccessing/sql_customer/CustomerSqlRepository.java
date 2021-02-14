package de.slimou.dataaccessing.sql_customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerSqlRepository extends CrudRepository<CustomerSql, Long> {

    List<CustomerSql> findByLastname(String lastname);

    CustomerSql findById(long id);

    void deleteById(Long id);

    long count();

    void deleteAll();
}
