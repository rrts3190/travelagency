package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.DivisionRepository;
import edu.wgu.d288_backend.dao.ExcursionRepository;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Excursion;
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
    public Division saveDivision(Division division) {
        return divisionRepository.save(division);
    }

    @Override
    public List<Division> getAllDivision() {
        return null;
    }
}
