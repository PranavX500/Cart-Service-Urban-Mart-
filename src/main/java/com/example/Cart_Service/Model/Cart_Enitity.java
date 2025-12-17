package com.example.Cart_Service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart_Enitity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long userId;


    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String brand;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;


    @Enumerated(EnumType.STRING)
    @Column(name = "categories")
    private Categories categories;



}
