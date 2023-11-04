package com.example.apemain.controller;

import com.example.apemain.domains.Artist;
import com.example.apemain.service.ArtistService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
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

    @PutMapping("/{artistName}/{recordLabelID}/{date}")
    private ResponseEntity<Boolean> putArtist(
            @PathVariable String artistName,
            @PathVariable int recordLabelID,
            @PathVariable Date date
    ){
        return ResponseEntity.ok(artistService.putAstist(artistName,recordLabelID,date));
    }
}
