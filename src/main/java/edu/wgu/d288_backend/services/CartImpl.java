package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartsRepository;
import edu.wgu.d288_backend.entities.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartImpl implements ICart{
    @Autowired
    CartsRepository cartsRepository;
    @Override
    public Carts saveCart(Carts cart) {
        return cartsRepository.save(cart);
    }

    @Override
    public Carts getCartById(long cartId) {
        return cartsRepository.findByCartId(cartId);
    }
}
