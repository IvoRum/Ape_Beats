package com.example.apemain.controller;

import com.example.apemain.domains.returns.MostSoldItem;
import com.example.apemain.domains.returns.ShopinCartItem;
import com.example.apemain.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/sale")
public class SaleController {

    private final SaleService service;

    @GetMapping("/most_sold_item")
    public ResponseEntity<MostSoldItem> getMostSoldItem(){
        return ResponseEntity.ok(service.getMostSoldItem());
    }

    @GetMapping("/cart/{userId}/{itemId}")
    public ResponseEntity<String> putIitemIntoCart(@PathVariable final int userId,@PathVariable final int itemId){
        return ResponseEntity.ok(service.putItemIntoCart(userId, itemId));
    }

    @GetMapping("/{userID}")
    public ResponseEntity<List<ShopinCartItem>> getShpingCartItemsByUserId(@PathVariable final int userID){
        return ResponseEntity.ok(service.getShpoingCartItemsByUserId(userID));
    }
}
