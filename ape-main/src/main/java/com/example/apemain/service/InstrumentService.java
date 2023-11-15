package com.example.apemain.service;

import com.example.apemain.domains.Instrument;
import com.example.apemain.repository.ApeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public
class InstrumentService {
    private final ApeRepository apeRepository;
    private final ItemService itemService;

    public
    List<Instrument> getAllInstruments() {
        try {
            return apeRepository.getAllInstrumentData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public
    boolean putInstrument(int price, String description, Date manufacturingDate, String name, int genreId,
                          int companyId, int type, Date date) {
        try {
            apeRepository.insertInstrument(price, description, manufacturingDate, name, genreId, companyId, type, date);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public
    void updateInstrumentName(int id, String name) {
        itemService.updateItemName(id, name);
    }

    public
    List<Instrument> getAllBrassInstruments() {
        try {
            return apeRepository.getAllBrassInstrument();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public
    List<Instrument> getAllGuitarInstruments() {
        try {
            return apeRepository.getAllGitarInstrument();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
