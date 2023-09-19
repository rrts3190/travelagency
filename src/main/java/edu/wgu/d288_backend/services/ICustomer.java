package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.entities.Vacation;

public interface ICustomer
{
    Customer addCustomer(Customer customer);
    Customer getCustomerByFirstName(String firstName);

    Customer getCustomerById(long customerId);
}
