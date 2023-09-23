package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.services.CountryImpl;
import edu.wgu.d288_backend.services.CustomerImpl;
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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController
{
    @Autowired
    private CountryImpl countryService;
    Logger logger = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/allCountry")
    public ResponseEntity<List<Country>> getAllCountry()
    {
        return ResponseEntity.ok(countryService.getAllCountry());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Country> getCustomerByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(countryService.getCountryByName(name));
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@Valid  @RequestBody Country country)
    {

        return new ResponseEntity<>(countryService.addCountry(country), HttpStatus.CREATED);
    }
}
