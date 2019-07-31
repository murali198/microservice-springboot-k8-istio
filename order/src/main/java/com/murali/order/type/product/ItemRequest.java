package com.murali.order.type.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ItemRequest {

    private Long productId;
    private BigDecimal quantity;
}
