package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Excursion;

public interface IExcursion
{
    Excursion getByExcursionId(long excursionId);
    Excursion saveExcursion(Excursion excursion);
}
