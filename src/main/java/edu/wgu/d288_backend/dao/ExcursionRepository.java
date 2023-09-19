package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, Long>
{
    Excursion findByExcursionId(long excursionId);
}
