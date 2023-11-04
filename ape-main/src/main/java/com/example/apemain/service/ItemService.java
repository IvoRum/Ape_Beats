package com.example.apemain.service;

import com.example.apemain.repository.ApeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    private final ApeRepository apeRepository;

    public void updateItemName(final int id, final String name){
        try {
            apeRepository.updateItemName(id,name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
