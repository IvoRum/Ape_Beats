package com.example.apemain.controller;

import com.example.apemain.domains.Record;
import com.example.apemain.service.RecordService;
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
@RequestMapping("api/v1/record")
public class RecordController {

    private final RecordService recordService;
    @GetMapping
    public ResponseEntity<List<Record>> getAllInstruments(){
        return ResponseEntity.ok(recordService.getAllRecords());
    }

    @PutMapping("/{price}/{description}/{manufacturingDate}/{name}/{genreId}/{companyId}/{date}/{artistId}/{recordLabelId}")
    public ResponseEntity<String> putRecord(
            @PathVariable int price,
            @PathVariable String description,
            @PathVariable Date manufacturingDate,
            @PathVariable String name,
            @PathVariable int genreId,
            @PathVariable int companyId,
            @PathVariable Date date,
            @PathVariable int artistId,
            @PathVariable int recordLabelId
    )
    {
        recordService.putRecord(price, description, manufacturingDate, name, genreId, companyId, date,artistId,recordLabelId);
        return ResponseEntity.ok("da");
    }
}
