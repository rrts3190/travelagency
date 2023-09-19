package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import edu.wgu.d288_backend.services.CartImpl;
import edu.wgu.d288_backend.services.CustomerImpl;
import edu.wgu.d288_backend.services.DivisionImpl;
import edu.wgu.d288_backend.services.ICart;
import edu.wgu.d288_backend.services.ICustomer;
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

@RestController
@RequestMapping("/cart")
public class CartController
{
    @Autowired
    private ICart cartService;

    @Autowired
    private ICustomer customerService;
    Logger logger = LoggerFactory.getLogger(CartController.class);
    @GetMapping("/{cartId}")
    public ResponseEntity<Carts> getCartById(@PathVariable("cartId") long cartId)
    {
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }

    @PostMapping("/{customerId}/addCart")
    public ResponseEntity<Carts> addCart(@PathVariable long customerId, @RequestBody Carts carts)
    {
        Customer customer = customerService.getCustomerById(customerId);
        carts.setCartsForeign(customer);
        return new ResponseEntity<>(cartService.saveCart(carts), HttpStatus.CREATED);
    }
}
