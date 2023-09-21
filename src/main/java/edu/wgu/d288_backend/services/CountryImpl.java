package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CountryRepository;
import edu.wgu.d288_backend.dao.VacationRepository;
import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryImpl implements ICountry{
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findByCountry(name);
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountry()
    {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long countryId) {
        return countryRepository.findById(countryId).get();
    }
}
