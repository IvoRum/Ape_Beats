package com.example.apemain.controller;

import com.example.apemain.domains.MostSoldItem;
import com.example.apemain.domains.StaticTableInfomation;
import com.example.apemain.service.ItemService;
import com.example.apemain.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/static")
public class StaticDateController {

    private final ItemService service;

    @GetMapping()
    public
    ResponseEntity<StaticTableInfomation> getStaticInfomation(){
        return ResponseEntity.ok(service.getStaticTableInformation());
    }

}
