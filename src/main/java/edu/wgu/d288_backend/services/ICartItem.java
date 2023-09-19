package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;

public interface ICartItem
{
    CartItems saveCartItem(CartItems cart);

    CartItems getCartItemById(long cartItemId);
}
