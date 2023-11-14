package com.example.order.translators;

import com.example.order.entity.Items;
import com.example.order.entity.OrderItems;
import com.example.order.entity.PayUProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class OrderItemsToItems
{
    public Items toItems(OrderItems orderItems)
    {
        return toItems2(orderItems);
    }

    @Mappings({
            @Mapping(target = "imageUrl", ignore = true),
    })
    protected abstract Items toItems2(OrderItems orderItems);
}
