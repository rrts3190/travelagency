package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    Customer findByCustomerId(long customerId);
    Customer findByFirstName(String name);
    Customer findByFirstNameAndLastName(String firstName, String LastName);

}
