package com.example.apemain.service;

import com.example.apemain.domains.Artist;
import com.example.apemain.domains.Record;
import com.example.apemain.repository.ApeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArtistService {


    private final ApeRepository repository;

    public List<Artist> getAllArtist(){
        try {
            return repository.getAllArtistData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
