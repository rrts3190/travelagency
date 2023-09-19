package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Vacation;

import java.util.List;

public interface ICountry
{
    Country getCountryByName(String name);
    Country addCountry(Country country);

    List<Country> getAllCountry();
}
