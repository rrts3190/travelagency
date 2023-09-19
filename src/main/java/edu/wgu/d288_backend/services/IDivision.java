package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Division;

import java.util.List;

public interface IDivision
{
    Division getDivisionById(long divisionId);
    Division saveDivision(Division division);
    List<Division> getAllDivision();
}
