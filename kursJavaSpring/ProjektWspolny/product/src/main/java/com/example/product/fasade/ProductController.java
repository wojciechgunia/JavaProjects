package com.example.product.fasade;

import com.example.product.entity.ProductFormDTO;
import com.example.product.entity.Response;
import com.example.product.mediator.ProductMediator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor
public class ProductController
{
    private final ProductMediator productMediator;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(HttpServletRequest request,
                                 @RequestParam(required = false) String name_like,
                                 @RequestParam(required = false) String data,
                                 @RequestParam(required = false) String _category,
                                 @RequestParam(required = false) Float price_min,
                                 @RequestParam(required = false) Float price_max,
                                 @RequestParam(required = false,defaultValue = "1") int _page,
                                 @RequestParam(required = false,defaultValue = "10") int _limit,
                                 @RequestParam(required = false,defaultValue = "price") String _sort,
                                 @RequestParam(required = false,defaultValue = "asc") String _order)
    {
        return productMediator.getProduct(_page,_limit,name_like,_category,price_min,price_max,data,_sort,_order);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Response> save(@RequestBody ProductFormDTO productFormDTO)
    {
        return productMediator.saveProduct(productFormDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@RequestParam String uid)
    {
        return productMediator.deleteProduct(uid);
    }

}
