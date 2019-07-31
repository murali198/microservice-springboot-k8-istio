package com.murali.order.type.order;

import com.murali.order.type.customer.Customer;
import com.murali.order.type.product.ItemDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@ToString
@Setter
public class CustomerOrderDetails {

    private Long orderId;
    private String externalReference;
    private Customer customer;
    private LocalDateTime createdDate;
    private List<ItemDto> items;
    private BigDecimal totalOrderCost;
    private BigDecimal totalOrderTax;
    private String version;
    
}
