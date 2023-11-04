package com.example.apemain.controller;

import com.example.apemain.service.InstrumentService;
import com.example.apemain.domains.Instrument;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/instrument")
public class InstrumentController {
    private final InstrumentService instrumentService;

    @GetMapping("/ping")
    private ResponseEntity<String> ping(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping
    public ResponseEntity<List<Instrument>> getAllInstruments(){
        return ResponseEntity.ok(instrumentService.getAllInstruments());
    }

    @PutMapping("/{price}/{description}/{manufacturingDate}/{name}/{genreId}/{companyId}/{date}/{type}")
    public ResponseEntity<String> putInstrument(
            @PathVariable int price,
            @PathVariable String description,
            @PathVariable Date manufacturingDate,
            @PathVariable String name,
            @PathVariable int genreId,
            @PathVariable int companyId,
            @PathVariable Date date,
            @PathVariable int type)
    {
        instrumentService.putInstrument(price, description, manufacturingDate, name, genreId, companyId, type, date);
        return ResponseEntity.ok("da");
    }
}
