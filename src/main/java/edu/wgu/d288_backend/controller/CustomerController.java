package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.services.CustomerImpl;
import edu.wgu.d288_backend.services.DivisionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    private CustomerImpl customerService;

    @Autowired
    private DivisionImpl divisionService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @GetMapping("/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(customerService.getCustomerByFirstName(name));
    }

    @PostMapping("/{divisionId}/addCustomer")
    public ResponseEntity<Customer> addCustomer(@PathVariable(value = "divisionId") long divisionId,
                                                @RequestBody Customer customer)
    {
        Division division = divisionService.getDivisionById(divisionId);
        customer.setCustomersForeign(division);
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }
}
