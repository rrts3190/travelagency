package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CustomerRepository;
import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.entities.Vacation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerImpl implements ICustomer
{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer)
    {
        Customer findCustomer = customerRepository.findByFirstNameAndLastName(customer.getFirstName(), customer.getLastName());
        if (findCustomer != null)
        {
            log.info("Customer already Present with same name as First name: {}, Last name: {}", customer.getFirstName(), customer.getLastName());
            findCustomer.setCustomersForeign(customer.getCustomersForeign());
            findCustomer.setAddress(customer.getAddress());
            findCustomer.setPostalCode(customer.getPostalCode());
            findCustomer.setPhone(customer.getPhone());
        }
        else
        {
            log.info("Newly customer creating");
            findCustomer = customer;
        }
        return customerRepository.save(findCustomer);
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
}
