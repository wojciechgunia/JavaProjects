package com.example.product.mediator;

import com.example.product.entity.*;
import com.example.product.exceptions.CategoryDontExistException;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import com.example.product.translator.ProductEntityToProductDTO;
import com.example.product.translator.ProductEntityToSimpleProduct;
import com.example.product.translator.ProductFormToProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${file-service.url}")
    private String FILE_SERVICE;

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductEntityToSimpleProduct productEntityToSimpleProduct;
    private final ProductEntityToProductDTO productEntityToProductDTO;
    private final ProductFormToProductEntity productFormToProductEntity;

    public ResponseEntity<?> getProduct(int page, int limit, String name, String category, Float price_min, Float price_max, String data, String sort, String order)
    {
        if(name != null && !name.isEmpty())
        {
            try
            {
                name = URLDecoder.decode(name, "UTF-8");
            } catch (UnsupportedEncodingException e)
            {
                throw new RuntimeException(e);
            }
        }
        List<ProductEntity> product = productService.getProduct(name, category, price_min, price_max, data, page, limit,sort,order);
//        product.forEach(value->{
//            for (int i = 0; i < value.getImageUrls().length; i++){
//                value.getImageUrls()[i] = FILE_SERVICE+"?uid="+value.getImageUrls()[i];
//            }
//        });
        if(name == null || name.isEmpty() || data == null || data.isEmpty())
        {
            List<SimpleProductDTO> simpleProductDTOS = new ArrayList<>();
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

    public ResponseEntity<Response> deleteProduct(String uid)
    {
        try
        {
            productService.delete(uid);
            return ResponseEntity.ok(new Response("Successful delete product"));
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            return ResponseEntity.status(400).body(new Response("Product dont exist"));
        }
    }
}
