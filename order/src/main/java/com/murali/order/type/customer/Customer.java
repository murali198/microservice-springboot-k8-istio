package com.murali.order.type.customer;

import com.murali.order.type.customer.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;
}
