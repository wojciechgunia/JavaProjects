package com.example.order.translators;

import com.example.order.entity.BasketItemDTO;
import com.example.order.entity.Deliver;
import com.example.order.entity.DeliverDTO;
import com.example.order.entity.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class BasketItemDTOToOrderItems
{
    public OrderItems toOrderItems(BasketItemDTO basketItemDTO)
    {
        return toOrderItems2(basketItemDTO);
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "product", source = "uuid"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "priceUnit", source = "price"),
            @Mapping(target = "priceSummary", source = "summaryPrice"),
    })
    protected abstract OrderItems toOrderItems2(BasketItemDTO basketItemDTO);
}
