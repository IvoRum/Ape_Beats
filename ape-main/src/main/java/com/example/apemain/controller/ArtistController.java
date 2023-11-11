package com.example.apemain.controller;

import com.example.apemain.domains.Artist;
import com.example.apemain.domains.create.CreateArtist;
import com.example.apemain.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{artistName}")
    private ResponseEntity<Artist> getArtistsByName(@PathVariable String artistName){
        return ResponseEntity.ok(artistService.getArtistByName(artistName));
    }

    @PutMapping()
    private ResponseEntity<Boolean> putArtist(
            @RequestBody CreateArtist createArtist
    ){
        return ResponseEntity.ok(artistService.putAstist(createArtist.artistName(),createArtist.recordLabelID(),createArtist.date()));
    }
}
