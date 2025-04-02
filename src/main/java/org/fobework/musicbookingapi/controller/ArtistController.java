package org.fobework.musicbookingapi.controller;

import org.fobework.musicbookingapi.dto.ApiResponse;
import org.fobework.musicbookingapi.dto.ArtistDto;
import org.fobework.musicbookingapi.dto.CreateArtistDto;
import org.fobework.musicbookingapi.services.Interface.ArtistInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private final ArtistInterface artistService;

    public ArtistController(ArtistInterface artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<ArtistDto> getArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getArtistById(@PathVariable Long id) {
        try {
            ArtistDto artistDto = artistService.getArtistById(id);
            return new ResponseEntity<>(new ApiResponse(true,artistDto), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createArtist(@RequestBody CreateArtistDto artist) {
        try {
            ArtistDto artistDto = artistService.createArtist(artist);
            return new ResponseEntity<>(new ApiResponse(true,artistDto), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateArtist(@PathVariable Long id, @RequestBody CreateArtistDto artist) {
        try {
            ArtistDto artistDto = artistService.updateArtist(id, artist);
            return new ResponseEntity<>(new ApiResponse(true,artistDto), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteArtist(@PathVariable Long id) {
        try {
            artistService.deleteArtist(id);
            return new ResponseEntity<>(new ApiResponse(true,true),HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}

