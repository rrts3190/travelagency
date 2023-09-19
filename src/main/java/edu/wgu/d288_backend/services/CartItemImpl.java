package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartItemsRepository;
import edu.wgu.d288_backend.entities.CartItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemImpl implements ICartItem{
    @Autowired
    CartItemsRepository cartItemsRepository;
    @Override
    public CartItems saveCartItem(CartItems cartItems) {
        return cartItemsRepository.save(cartItems);
    }

    @Override
    public CartItems getCartItemById(long cartItemId) {
        return cartItemsRepository.findByCartItemId(cartItemId);
    }
}
