package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Country;
import edu.wgu.d288_backend.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>
{
    @Override
    Division getById(Long divisionId);
}
