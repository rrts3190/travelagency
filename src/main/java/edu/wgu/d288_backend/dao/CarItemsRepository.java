package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarItemsRepository extends JpaRepository<CartItems, Long>
{

}
