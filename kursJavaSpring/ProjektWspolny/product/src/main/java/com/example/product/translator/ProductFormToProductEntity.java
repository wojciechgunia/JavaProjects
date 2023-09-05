package com.example.product.translator;

import com.example.product.entity.Category;
import com.example.product.entity.ProductEntity;
import com.example.product.entity.ProductFormDTO;
import com.example.product.entity.SimpleProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class ProductFormToProductEntity
{
    public ProductEntity toProductEntity(ProductFormDTO productFormDTO)
    {
        return toEntity(productFormDTO);
    }

    @Mappings({
            @Mapping(target = "category", expression = "java(translate(productFormDTO.getCategory()))")
    })
    protected abstract ProductEntity toEntity(ProductFormDTO productFormDTO);

    protected Category translate(String uid)
    {
        Category category = new Category();
        category.setShortId(uid);
        return category;
    }


}
