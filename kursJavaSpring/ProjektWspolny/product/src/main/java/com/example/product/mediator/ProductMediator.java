package com.example.product.mediator;

import com.example.product.entity.ProductDTO;
import com.example.product.entity.ProductEntity;
import com.example.product.entity.SimpleProductDTO;
import com.example.product.service.ProductService;
import com.example.product.translator.ProductEntityToProductDTO;
import com.example.product.translator.ProductEntityToSimpleProduct;
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
    private final ProductEntityToSimpleProduct productEntityToSimpleProduct;
    private final ProductEntityToProductDTO productEntityToProductDTO;

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
}
