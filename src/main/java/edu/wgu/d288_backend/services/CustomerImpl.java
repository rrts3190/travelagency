package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CustomerRepository;
import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.entities.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements ICustomer
{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer)
    {
        return customerRepository.save(customer);
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
