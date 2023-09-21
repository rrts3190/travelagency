package edu.wgu.d288_backend;

import com.google.common.collect.Sets;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.services.CartImpl;
import edu.wgu.d288_backend.services.CustomerImpl;
import edu.wgu.d288_backend.services.DivisionImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@OpenAPIDefinition
@Log4j2
public class TravelagencyApplication {

	public static void addCustomerThroughProgrammatically(ApplicationContext context, String fName, String lName, String phone,
												   String postalCode, String address, int divisionId)
	{
		log.info("TravelAgencyApplication | addCustomerThroughProgrammatically is called");
		CustomerImpl customerService = context.getBean(CustomerImpl.class);
		DivisionImpl divisionService = context.getBean(DivisionImpl.class);

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

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(TravelagencyApplication.class, args);

		TravelagencyApplication.addCustomerThroughProgrammatically(context, "Pratik", "Agrawal", "3256",
				"560231", "Mulund", 8);
		TravelagencyApplication.addCustomerThroughProgrammatically(context, "Myukh", "Roy", "123",
				"700001", "Bhandup", 4);
		TravelagencyApplication.addCustomerThroughProgrammatically(context, "Vimarsh", "Dubey", "456",
				"600001", "Ghatkopar", 5);
		TravelagencyApplication.addCustomerThroughProgrammatically(context, "Aman", "Agrawal", "789",
				"500001", "Dadar", 6);
		TravelagencyApplication.addCustomerThroughProgrammatically(context, "Soham", "Pandit", "852",
				"100001", "CST", 7);

	}
	//using this link to get all endpoint of api, http://localhost:8080/swagger-ui.html

}
