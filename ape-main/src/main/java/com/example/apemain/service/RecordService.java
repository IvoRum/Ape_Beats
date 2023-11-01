package com.example.apemain.service;

import com.example.apemain.domains.Record;
import com.example.apemain.repository.ApeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {
    private final ApeRepository repository;

    public List<Record> getAllRecords(){
        try {
            return repository.getAllRecordData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
