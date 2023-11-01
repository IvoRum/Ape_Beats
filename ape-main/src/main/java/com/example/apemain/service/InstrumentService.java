package com.example.apemain.service;

import com.example.apemain.domains.Instrument;
import com.example.apemain.repository.ApeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstrumentService {
    private final ApeRepository apeRepository;

    public List<Instrument> getAllInstruments(){
        try {
            return apeRepository.getAllInstrumentData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
