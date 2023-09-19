package edu.wgu.d288_backend.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseData
{
    private long customerId;
    private long cartId;
    private Set<Long> cartItemsId;
}
