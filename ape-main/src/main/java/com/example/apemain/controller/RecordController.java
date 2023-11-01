package com.example.apemain.controller;

import com.example.apemain.domains.Record;
import com.example.apemain.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
