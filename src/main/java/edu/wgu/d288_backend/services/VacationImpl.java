package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartItemsRepository;
import edu.wgu.d288_backend.dao.VacationRepository;
import edu.wgu.d288_backend.entities.CartItems;
import edu.wgu.d288_backend.entities.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationImpl implements IVacation{
    @Autowired
    VacationRepository vacationRepository;

    @Override
    public Vacation getVacationById(long vacationId) {
        return vacationRepository.findByVacationId(vacationId);
    }

    @Override
    public Vacation saveVacation(Vacation vacation) {
        return vacationRepository.save(vacation);
    }
}
