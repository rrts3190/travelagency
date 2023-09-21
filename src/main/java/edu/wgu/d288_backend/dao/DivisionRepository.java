package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>
{
    @Override
    Division getById(Long divisionId);


    Division findByDivision(@Param("divisionName") String divisionName);
}
