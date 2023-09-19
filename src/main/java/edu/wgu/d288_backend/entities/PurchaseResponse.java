package edu.wgu.d288_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseResponse
{
    private long customerId;
    private long cartId;
    private String orderTrackingNum;
}
