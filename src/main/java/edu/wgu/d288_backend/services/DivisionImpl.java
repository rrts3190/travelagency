package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.DivisionRepository;
import edu.wgu.d288_backend.dao.ExcursionRepository;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionImpl implements IDivision{
    @Autowired
    DivisionRepository divisionRepository;


    @Override
    public Division getDivisionById(long divisionId) {
        return divisionRepository.getById(divisionId);
    }

    @Override
    public Division saveDivision(Division division)
    {
        Division division1 = divisionRepository.findByDivision(division.getDivision());
        if (division1 != null)
        {
            division1.setDivision(division.getDivision());
            division1.setCountryForeign(division.getCountryForeign());
            division1.setCustomers(division.getCustomers());
            division1.setCountryForeign(division.getCountryForeign());
        }
        else
        {
            division1 = division;
        }
        return divisionRepository.save(division1);
    }

    @Override
    public List<Division> getAllDivision() {
        return null;
    }
}
