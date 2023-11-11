package com.example.apemain.service;

import com.example.apemain.domains.returns.MostSoldItem;
import com.example.apemain.repository.ApeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {
    private final ApeRepository apeRepository;

    public MostSoldItem getMostSoldItem(){
        try{
            return apeRepository.getMostSoldItem();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
