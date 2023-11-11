package com.example.apemain.controller;

import com.example.apemain.domains.create.CreateInstrument;
import com.example.apemain.domains.update.UpdateItemName;
import com.example.apemain.service.InstrumentService;
import com.example.apemain.domains.Instrument;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping()
    public ResponseEntity<String> putInstrument(@RequestBody CreateInstrument createInstrument)
    {
        instrumentService.putInstrument(
                createInstrument.price(),
                createInstrument.description(),
                createInstrument.manufacturingDate(),
                createInstrument.name(),
                createInstrument.genreId(),
                createInstrument.companyId(),
                createInstrument.type(),
                createInstrument.date()
        );
        return ResponseEntity.ok("da");
    }

    @PostMapping()
    public ResponseEntity<String> updateInstrument(@RequestBody UpdateItemName updateItemName){
        instrumentService.updateInstrumentName(updateItemName.id(),updateItemName.name());
        return ResponseEntity.ok("da");
    }
}
