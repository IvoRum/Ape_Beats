package com.example.apemain.controller;

import com.example.apemain.service.InstrumentService;
import com.example.apemain.domains.Instrument;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
