package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>
{
    Country findByCountry(String name);
}
