package com.example.order.translators;

import com.example.order.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class OrderToOrderDTO
{
    public OrderDTO toOrderDTO(Order order)
    {
        return toDTO(order);
    }

    @Mappings({
            @Mapping(expression = "java(translateToCustomer(order))",target = "customerDetails"),
            @Mapping(expression = "java(translateToAddress(order))",target = "address"),
            @Mapping(expression = "java(translateToDeliver(order))",target = "deliver"),
    })
    protected abstract OrderDTO toDTO(Order order);

    @Mappings({})
    protected abstract CustomerDetails translateToCustomer(Order order);

    @Mappings({})
    protected abstract Address translateToAddress(Order order);

    @Mappings({})
    protected abstract Deliver translateToDeliver(Order order);
}
