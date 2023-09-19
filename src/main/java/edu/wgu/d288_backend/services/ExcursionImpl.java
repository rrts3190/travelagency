package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartItemsRepository;
import edu.wgu.d288_backend.dao.ExcursionRepository;
import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcursionImpl implements IExcursion{
    @Autowired
    ExcursionRepository excursionRepository;

    @Override
    public Excursion getByExcursionId(long excursionId) {
        return excursionRepository.findByExcursionId(excursionId);
    }

    @Override
    public Excursion saveExcursion(Excursion excursion) {
        return excursionRepository.save(excursion);
    }
}
