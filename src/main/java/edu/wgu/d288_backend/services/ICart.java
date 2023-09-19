package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Carts;

public interface ICart
{
    Carts saveCart(Carts cart);
    Carts getCartById(long cartId);
}
