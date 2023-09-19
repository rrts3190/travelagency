package edu.wgu.d288_backend.controller;

import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.entities.Vacation;
import edu.wgu.d288_backend.services.CartItemImpl;
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
@RequestMapping("/excursion")
public class ExcursionController
{
    @Autowired
    private ExcursionImpl excursionService;

    @Autowired
    private CartItemImpl cartItemsService;

    @Autowired
    private VacationImpl vacationService;
    Logger logger = LoggerFactory.getLogger(ExcursionController.class);
    @GetMapping("/{excursionId}")
    public ResponseEntity<Excursion> getCartItemById(@PathVariable("excursionId") long excursionId)
    {
        return ResponseEntity.ok(excursionService.getByExcursionId(excursionId));
    }

    @PostMapping("/{cartItemIds}/{vacationId}/addExcursion")
    public ResponseEntity<Excursion> addExcursion(@PathVariable long vacationId,
                                                  @PathVariable List<Long> cartItemIds,
                                                 @RequestBody Excursion excursion)
    {
        Vacation vacation = vacationService.getVacationById(vacationId);
        excursion.setExcursionsForeign(vacation);
        for(long cartItemId : cartItemIds)
        {
            CartItems cartItem = cartItemsService.getCartItemById(cartItemId);
            cartItem.addExcursion(excursion);
        }

        return new ResponseEntity<>(excursionService.saveExcursion(excursion), HttpStatus.CREATED);
    }
}
