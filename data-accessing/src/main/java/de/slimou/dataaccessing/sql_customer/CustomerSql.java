package de.slimou.dataaccessing.sql_customer;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class CustomerSql {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    public CustomerSql() {}

    public CustomerSql(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format(
                "CustomerSql[id=%d, firstname='%s', lastname='%s']",
                id, firstname, lastname);
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
