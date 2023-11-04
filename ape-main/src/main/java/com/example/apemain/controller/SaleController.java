package com.example.apemain.controller;

import com.example.apemain.domains.MostSoldItem;
import com.example.apemain.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/sale")
public class SaleController {

    private final SaleService service;

    @GetMapping("/most_sold_item")
    public ResponseEntity<MostSoldItem> getMostSoldItem(){
        return ResponseEntity.ok(service.getMostSoldItem());
    }
}
