package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Vacation;
import edu.wgu.d288_backend.services.VacationImpl;
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
@RequestMapping("/vacation")
public class VacationController
{
    @Autowired
    private VacationImpl vacationService;
    Logger logger = LoggerFactory.getLogger(VacationController.class);
    @GetMapping("/{vacationId}")
    public ResponseEntity<Vacation> getDivisionByName(@PathVariable("vacationId") long vacationId)
    {
        return ResponseEntity.ok(vacationService.getVacationById(vacationId));
    }

    @PostMapping("/addVacation")
    public ResponseEntity<Vacation> addVacation(@RequestBody Vacation vacation)
    {
        return new ResponseEntity<>(vacationService.saveVacation(vacation), HttpStatus.CREATED);
    }
}
