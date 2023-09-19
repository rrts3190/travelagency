package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Carts;
import edu.wgu.d288_backend.entities.Vacation;

public interface IVacation
{
    Vacation getVacationById(long vacationId);
    Vacation saveVacation(Vacation vacation);
}
