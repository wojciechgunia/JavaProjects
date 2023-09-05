package com.example.product.mediator;

import com.example.product.entity.*;
import com.example.product.exceptions.CategoryDontExistException;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import com.example.product.translator.ProductEntityToProductDTO;
import com.example.product.translator.ProductEntityToSimpleProduct;
import com.example.product.translator.ProductFormToProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMediator
{
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductEntityToSimpleProduct productEntityToSimpleProduct;
    private final ProductEntityToProductDTO productEntityToProductDTO;
    private final ProductFormToProductEntity productFormToProductEntity;

    public ResponseEntity<?> getProduct(int page, int limit, String name, String category, Float price_min, Float price_max, String data, String sort, String order)
    {
        List<ProductEntity> product = productService.getProduct(name, category, price_min, price_max, data, page, limit,sort,order);
        if(name == null || name.isEmpty() || data == null || data.isEmpty())
        {
            List<SimpleProductDTO> simpleProductDTOS = new ArrayList<>();
            try
            {
                name = URLDecoder.decode(name, "UTF-8");
            }
            catch(UnsupportedEncodingException e)
            {
                throw new RuntimeException(e);
            }
            long totalCount = productService.countActiveProducts(name, category, price_min, price_max);
            product.forEach(value->{
                simpleProductDTOS.add(productEntityToSimpleProduct.toSimpleProduct(value));
            });
            return ResponseEntity.ok().header("X-Total-Count",String.valueOf(totalCount)).body(simpleProductDTOS);
        }
        ProductDTO productDTO = productEntityToProductDTO.toProductDTO(product.get(0));
        return ResponseEntity.ok().body(productDTO);
    }

    public ResponseEntity<Response> saveProduct(ProductFormDTO productFormDTO)
    {
        try
        {
            ProductEntity productEntity = productFormToProductEntity.toProductEntity(productFormDTO);
            categoryService.findCategoryByShortID(productEntity.getCategory().getShortId()).ifPresentOrElse(productEntity::setCategory, ()->{
                throw new CategoryDontExistException();
            });
            productService.createProduct(productEntity);
            return ResponseEntity.ok(new Response("Successful created a product"));
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(400).body(new Response("Can't create product, category don't exist"));
        }
    }
}
