package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.PurchaseData;
import edu.wgu.d288_backend.entities.PurchaseResponse;
import edu.wgu.d288_backend.services.CheckOutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/checkout")
public class CheckOutController
{
    @Autowired
    private CheckOutService checkOutService;

    Logger logger = LoggerFactory.getLogger(CartItemController.class);

    @PostMapping("/checkoutByCustomer")
    public ResponseEntity<PurchaseResponse> checkoutByCustomer(@RequestBody PurchaseData purchaseData)
    {
        logger.info("CheckOutController | checkoutByCustomer is called");

        PurchaseResponse purchase = checkOutService.checkout(purchaseData);
        if (purchase.getOrderTrackingNum().isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.info("CheckOutController | checkoutByCustomer |checkout for customerId: {}, cartId: {}, tracking Number: {}"
                , purchaseData.getCustomerId(), purchaseData.getCartId(), purchase.getOrderTrackingNum());
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }
}
