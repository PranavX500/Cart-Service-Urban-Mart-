package com.example.Cart_Service.DTO;

import com.example.Cart_Service.Model.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long CartId;
    private Long productId;
    private Long userId;
    private String productName;
    private Double price;
    private int quantity;
    private String description;
    private String brand;
    private String imageUrl;
    private Categories categories;
}
