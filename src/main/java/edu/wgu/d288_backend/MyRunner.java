package edu.wgu.d288_backend;

import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.services.CustomerImpl;
import edu.wgu.d288_backend.services.DivisionImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner
{
    @Autowired
    private CustomerImpl customerService;

    @Autowired
    private DivisionImpl divisionService;

    public void addCustomerThroughProgrammatically(String fName, String lName, String phone, String postalCode, String address, int divisionId)
    {
        log.info("TravelAgencyApplication | addCustomerThroughProgrammatically is called");

        Division division = divisionService.getDivisionById(divisionId);
        log.info("DivisionData - {}", division.getDivision());

        Customer customer = Customer.builder().customersForeign(division)
                .phone(phone)
                .address(address)
                .firstName(fName)
                .lastName(lName)
                .postalCode(postalCode)
                .build();

        Customer addedCustomer = customerService.addCustomer(customer);
        log.info("Customer added, with CustomerId : {}", addedCustomer.getCustomerId());
    }

    @Override
    public void run(String... args)
    {
        addCustomerThroughProgrammatically("Pratik", "Agrawal", "3256","560231", "Mulund", 8);
        addCustomerThroughProgrammatically("Myukh", "Roy", "123","700001", "Bhandup", 4);
        addCustomerThroughProgrammatically("Vimarsh", "Dubey", "456","600001", "Ghatkopar", 5);
        addCustomerThroughProgrammatically("Aman", "Agrawal", "789","500001", "Dadar", 6);
        addCustomerThroughProgrammatically("Soham", "Pandit", "852","100001", "CST", 7);
    }
}
