package com.example.Cart_Service.Service;

import com.example.Cart_Service.DTO.ProductDto;
import com.example.Cart_Service.Model.Cart_Enitity;
import com.example.Cart_Service.ProductClient.ProductClient;
import com.example.Cart_Service.Repositery.CartRepositery;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ProductClient productClient;
    @Autowired
    CartRepositery  cartRepositery;
    public ProductDto productDto(Long id,Long UserId){


        ProductDto productDto=productClient.findById(id);
        Cart_Enitity c1=new Cart_Enitity();
        Cart_Enitity c2=cartRepositery.findByUserIdAndProductId(UserId,id);
        if(c2!=null){
            c2.setQuantity(c2.getQuantity()+1);
            cartRepositery.save(c2);
        }
        else {

            c1.setProductId(productDto.getProductId());
            c1.setUserId(UserId);
            c1.setBrand(productDto.getBrand());
            c1.setPrice(productDto.getPrice());
            c1.setProductName(productDto.getProductName());
            c1.setDescription(productDto.getDescription());
            c1.setImageUrl(productDto.getImageUrl());
            c1.setCategories(productDto.getCategories());
            c1.setQuantity(1);
            Cart_Enitity save = cartRepositery.save(c1);
            productDto.setUserId(UserId);
        }
        return productDto;


    }
    public void deleteByCartId(Long cartId, Long userId) {
        try {
            int deleted = cartRepositery.deleteCartByIdAndUserId(cartId, userId);

            if (deleted == 0) {
                throw new RuntimeException("No cart item found for this user");
            }

            System.out.println("Product deleted successfully");

        } catch (Exception e) {
            System.out.println("Error while deleting cart: " + e.getMessage());
            throw new RuntimeException("Failed to delete cart item");
        }
    }

    public void deleteAllByUserId(Long userID){
        try{
            int deleted=cartRepositery.deleteCartAllByUserId(userID);
            if(deleted==0){
                throw new RuntimeException("No cart item found for this user");
            }
            System.out.println("Products deleted successfully");

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete cart item");
        }
    }

    public ProductDto MapToDto(Cart_Enitity cartEnitity){

        ProductDto responseDto = new ProductDto();
        responseDto.setCartId(cartEnitity.getId());
        responseDto.setProductId(cartEnitity.getProductId());
        responseDto.setProductName( cartEnitity.getProductName());
        responseDto.setDescription( cartEnitity.getDescription());
        responseDto.setPrice( cartEnitity.getPrice());

        responseDto.setQuantity( cartEnitity.getQuantity());
        responseDto.setBrand( cartEnitity.getBrand());
        responseDto.setImageUrl( cartEnitity.getImageUrl());
        responseDto.setCategories( cartEnitity.getCategories());


        return responseDto;

    }

    public List<ProductDto>CartDtos( Long UserId){
     List<Cart_Enitity> c1=cartRepositery.findByUserId(UserId);
        return  c1.stream()
                .map(this:: MapToDto)
                .toList();


    }

}
