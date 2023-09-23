package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartsRepository;
import edu.wgu.d288_backend.entities.Carts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartImpl implements ICart{
    @Autowired
    CartsRepository cartsRepository;
    @Override
    public Carts saveCart(Carts cart)
    {
        Carts carts = cartsRepository.findByOrderTrackNum(cart.getOrderTrackNum());
        if (carts != null)
        {
            log.info("Cart already present, going for update that cart");
            carts.setStatus(cart.getStatus());
            carts.setPartySize(cart.getPartySize());
            carts.setPkgPrice(cart.getPkgPrice());
            if (cart.getCartsForeign() != null)
            {
                carts.setCartsForeign(cart.getCartsForeign());
            }
            if (cart.getCartItemsSet() != null && !cart.getCartItemsSet().isEmpty())
            {
                carts.setCartItemsSet(cart.getCartItemsSet());
            }
        }
        else
        {
            log.info("Newly cart creating");
            carts = cart;
        }

        return cartsRepository.save(carts);
    }

    @Override
    public Carts getCartById(long cartId) {
        return cartsRepository.findByCartId(cartId);
    }
}
