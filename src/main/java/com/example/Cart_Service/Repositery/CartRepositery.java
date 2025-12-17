package com.example.Cart_Service.Repositery;

import com.example.Cart_Service.DTO.ProductDto;
import com.example.Cart_Service.Model.Cart_Enitity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepositery extends JpaRepository<Cart_Enitity,Long > {
  List<Cart_Enitity>findByUserId(Long userId);
    Cart_Enitity findByUserIdAndProductId(Long userId, Long  id);
    Optional<Cart_Enitity>findByuserId(Long userId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart_Enitity c WHERE c.id = :id AND c.userId=:userId")

    int deleteCartByIdAndUserId(@Param("id") Long id, @Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cart_Enitity c WHERE c.userId=:userId")
    int deleteCartAllByUserId(@Param("userId")Long userId);


}
