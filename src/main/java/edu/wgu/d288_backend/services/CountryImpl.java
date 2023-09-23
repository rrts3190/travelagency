package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CountryRepository;
import edu.wgu.d288_backend.dao.VacationRepository;
import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Vacation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CountryImpl implements ICountry{
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findByCountry(name);
    }

    @Override
    public Country addCountry(Country country)
    {
        Country foundCountry  = countryRepository.findByCountry(country.getCountry());
        if (foundCountry != null)
        {
            log.info("Country already present in database, going for update it.");
            if (country.getDivisions() != null && !country.getDivisions().isEmpty())
            {
                foundCountry.setDivisions(foundCountry.getDivisions());
            }
        }
        else
        {
            log.info("going for adding new country");
            foundCountry = country;
        }
        return countryRepository.save(foundCountry);
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
