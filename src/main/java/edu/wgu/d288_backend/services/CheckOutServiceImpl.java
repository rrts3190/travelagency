package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartItemsRepository;
import edu.wgu.d288_backend.dao.CartsRepository;
import edu.wgu.d288_backend.dao.CustomerRepository;
import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.PurchaseData;
import edu.wgu.d288_backend.entities.PurchaseResponse;
import edu.wgu.d288_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CheckOutServiceImpl implements CheckOutService
{
    @Autowired
    CartsRepository cartsRepository;

    @Override
    public PurchaseResponse checkout(PurchaseData data)
    {
        String orderTrackingNumber;

        Carts cart = cartsRepository.findById(data.getCartId())
                .orElseThrow(() -> new ResourceNotFoundException
                ("CartId not Found for given CustomerId, cartId - " + data.getCartId()));

        Set<Long> cartItemsId = cart.getCartItemsSet().stream()
                .map(CartItems::getCartItemId).collect(Collectors.toSet());

        if (cart.getCartsForeign().getCustomerId() == data.getCustomerId()
            && cartItemsId.equals(data.getCartItemsId()))
        {
            orderTrackingNumber = cart.getOrderTrackNum();
        }
        else
        {
            throw new ResourceNotFoundException("Purchase does not match, we have stored data for Customer, CustomerId "
                    + cart.getCartsForeign().getCustomerId() + " CartItem - " + cartItemsId);
        }

        return PurchaseResponse
                .builder()
                .customerId(data.getCustomerId())
                .cartId(data.getCartId())
                .orderTrackingNum(orderTrackingNumber).build();
    }
}
