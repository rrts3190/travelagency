package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.PurchaseData;
import edu.wgu.d288_backend.entities.PurchaseResponse;

public interface CheckOutService
{
    PurchaseResponse checkout(PurchaseData data);
}
