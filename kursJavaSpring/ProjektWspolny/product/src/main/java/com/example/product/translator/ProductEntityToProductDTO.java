package com.example.product.translator;

import com.example.product.entity.Category;
import com.example.product.entity.CategoryDTO;
import com.example.product.entity.ProductDTO;
import com.example.product.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper
public abstract class ProductEntityToProductDTO
{
    public ProductDTO toProductDTO(ProductEntity productEntity)
    {
        return toDTO(productEntity);
    }

    @Mappings({
            @Mapping(target = "categoryDTO", expression = "java(toCategoryDTO(productEntity.getCategory()))")
    })
    protected abstract ProductDTO toDTO(ProductEntity productEntity);

    @Mappings({})
    protected abstract CategoryDTO toCategoryDTO(Category category);

}
