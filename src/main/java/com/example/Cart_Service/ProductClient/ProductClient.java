package com.example.Cart_Service.ProductClient;

import com.example.Cart_Service.DTO.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Product-Service",url="http://localhost:8085")
public interface ProductClient {
    @GetMapping("/Product/products/{id}")
    ProductDto findById(@PathVariable("id") Long id);

}
