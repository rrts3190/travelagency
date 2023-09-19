package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.entities.Vacation;
import edu.wgu.d288_backend.services.CartImpl;
import edu.wgu.d288_backend.services.CartItemImpl;
import edu.wgu.d288_backend.services.CustomerImpl;
import edu.wgu.d288_backend.services.ExcursionImpl;
import edu.wgu.d288_backend.services.VacationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cartItem")
public class CartItemController
{
    @Autowired
    private CartImpl cartService;

    @Autowired
    private CartItemImpl cartItemService;

    @Autowired
    private VacationImpl vacationService;
    Logger logger = LoggerFactory.getLogger(CartItemController.class);
    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItems> getCartItemById(@PathVariable("cartItemId") long cartItemId)
    {
        return ResponseEntity.ok(cartItemService.getCartItemById(cartItemId));
    }

    @PostMapping("/{cartId}/{vacationId}/addCartItem")
    public ResponseEntity<CartItems> addCartItem(@PathVariable long cartId,
                                                 @PathVariable long vacationId,
                                                 @RequestBody CartItems cartItem)
    {
        Carts carts = cartService.getCartById(cartId);
        cartItem.setCartItemsForeign(carts);

        Vacation vacation = vacationService.getVacationById(vacationId);
        cartItem.setVacationForeign(vacation);

        return new ResponseEntity<>(cartItemService.saveCartItem(cartItem), HttpStatus.CREATED);
    }
}
