package com.example.apemain.controller;

import com.example.apemain.domains.StaticTableInfomation;
import com.example.apemain.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
/*
    @GetMapping("/genres")
    public ResponseEntity<List<String>> getStaticGenresNames(){
        return ResponseEntity.ok(service.getGenresNames());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getStaticTypesNames(){
        return ResponseEntity.ok(service.getTypesNames());
    }

    @GetMapping("/company")
    public ResponseEntity<List<String>> getStaticCompanyiessNames(){
        return ResponseEntity.ok(service.getCompaniesNames());
    }

    @GetMapping("/artist")
    public ResponseEntity<List<String>> getStaticArtistNames(){
        return ResponseEntity.ok(service.getArtistNames());
    }

    @GetMapping("/record-lebel")
    public ResponseEntity<List<String>> getStaticRecordLabelNames(){
        return ResponseEntity.ok(service.getRecordLabelNames());
    }

    @GetMapping("/record")
    public ResponseEntity<List<String>> getStaticRecordNames(){
        return ResponseEntity.ok(service.getRecordNames());
    }

    @GetMapping("/instrument")
    public ResponseEntity<List<String>> getStaticInstrumentNames(){
        return ResponseEntity.ok(service.getInstrumentNames());
    }
*/
}
