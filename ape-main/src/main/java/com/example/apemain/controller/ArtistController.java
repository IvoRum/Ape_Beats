package com.example.apemain.controller;

import com.example.apemain.domains.Artist;
import com.example.apemain.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/artist")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    private ResponseEntity<List<Artist>> getAllArtists(){
        return ResponseEntity.ok(artistService.getAllArtist());
    }
}
