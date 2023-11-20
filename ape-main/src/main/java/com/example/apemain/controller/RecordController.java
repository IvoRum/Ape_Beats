package com.example.apemain.controller;

import com.example.apemain.domains.create.CreateRecord;
import com.example.apemain.domains.Record;
import com.example.apemain.domains.update.UpdateItemName;
import com.example.apemain.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping()
    public ResponseEntity<String> putRecord(@RequestBody CreateRecord createRecord)
    {
        recordService.putRecord(createRecord.price(), createRecord.description(), createRecord.manufacturingDate(), createRecord.name(), createRecord.genreId(), createRecord.companyId(), createRecord.date(),createRecord.artistId(),createRecord.recordLabelId());
        return ResponseEntity.ok("da");
    }

    @PostMapping()
    public ResponseEntity<String> updateRecord(@RequestBody UpdateItemName updateItemName){
        recordService.updateInstrumentName(updateItemName.id(),updateItemName.name());
        return ResponseEntity.ok("da");
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<String> deleteRecord(@PathVariable int recordId){
        recordService.deleteRecord(recordId);
        return ResponseEntity.ok("da");
    }
}
