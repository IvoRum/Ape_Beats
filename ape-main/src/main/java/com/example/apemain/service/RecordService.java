package com.example.apemain.service;

import com.example.apemain.domains.Record;
import com.example.apemain.repository.ApeRepository;
import com.example.apemain.repository.DeleteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {
    private final ApeRepository repository;
    private final ItemService itemService;
    private final DeleteRepository deleteRepository;

    public List<Record> getAllRecords(){
        try {
            return repository.getAllRecordData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putRecord(int price, String description, Date manufacturingDate, String name, int genreId, int companyId, Date date, int artistId, int recordLabelId) {
        try {
            repository.insertRecord(price, description, manufacturingDate, name, genreId, companyId, date,artistId,recordLabelId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInstrumentName(int id, String name) {
        itemService.updateItemName(id,name);
    }

    public void deleteRecord(int recordId) {
        try {
            deleteRepository.deleteRecord(recordId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
