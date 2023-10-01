package com.example.order.translators;

import com.example.order.entity.OrderItems;
import com.example.order.entity.PayUProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class OrderItemsToPayUProduct
{
    public PayUProduct toPayUProduct(OrderItems orderItems)
    {
        return toPayU(orderItems);
    }

    @Mappings({
            @Mapping(target = "unitPrice", source = "priceUnit")
    })
    protected abstract PayUProduct toPayU(OrderItems orderItems);
}
