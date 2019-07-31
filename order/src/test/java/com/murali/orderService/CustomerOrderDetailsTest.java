package com.murali.orderService;

import com.murali.order.type.customer.Address;
import com.murali.order.type.customer.Customer;
import com.murali.order.type.order.CustomerOrderDetails;
import com.murali.order.type.product.ItemDto;
import com.murali.order.type.product.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Arrays;

public class CustomerOrderDetailsTest {

    @Test
    public void test() throws JsonProcessingException {
        final CustomerOrderDetails customer = CustomerOrderDetails.builder()
                .orderId(1234L)
                .externalReference("234257hf")
                .customer(Customer.builder()
                        .firstName("anirudh")
                        .lastName("bhatnagar")
                        .address(Address.builder().addressLine1("123")
                                .city("Syd")
                                .country("Aus").build())
                        .email("test@test.com").build())
                .items(Arrays.asList(
                        ItemDto.builder()
                                .product(ProductDto
                                        .builder()
                                        .name("Nike Shoes")
                                        .description("Mens shoes")
                                        .sku("1234")
                                        .price("100").build()).build()))
                .build();
        ObjectMapper o = new ObjectMapper();
        System.out.println(o.writeValueAsString(customer));

    }
}
