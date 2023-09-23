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

	public static void main(String[] args) {
		SpringApplication.run(TravelagencyApplication.class, args);
	}
	//using this link to get all endpoint of api, http://localhost:8080/swagger-ui.html

}
