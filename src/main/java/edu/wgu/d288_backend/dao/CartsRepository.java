package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Long>
{
    Carts findByCartId(long cartId);
    Carts findByOrderTrackNum(String orderTrackNum);
}
