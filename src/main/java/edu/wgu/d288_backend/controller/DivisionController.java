package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.services.CountryImpl;
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

import java.util.List;

@RestController
@RequestMapping("/division")
public class DivisionController
{
    @Autowired
    private DivisionImpl divisionService;

    @Autowired
            private CountryImpl countryService;
    Logger logger = LoggerFactory.getLogger(DivisionController.class);

    @GetMapping("/allDivision")
    public ResponseEntity<List<Division>> getAllDivision()
    {
        return ResponseEntity.ok(divisionService.getAllDivision());
    }
    @GetMapping("/{divisionId}")
    public ResponseEntity<Division> getDivisionById(@PathVariable("divisionId") long divisionId)
    {
        return ResponseEntity.ok(divisionService.getDivisionById(divisionId));
    }

    @PostMapping("/{countryId}/addDivision")
    public ResponseEntity<Division> addDivision(@PathVariable("countryId") long countryId, @RequestBody Division division)
    {
        Country country = countryService.getCountryById(countryId);
        division.setCountryForeign(country);
        return new ResponseEntity<>(divisionService.saveDivision(division), HttpStatus.CREATED);
    }
}
