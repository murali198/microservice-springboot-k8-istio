package com.murali.order.type.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private String price;
    private String sku;
}
