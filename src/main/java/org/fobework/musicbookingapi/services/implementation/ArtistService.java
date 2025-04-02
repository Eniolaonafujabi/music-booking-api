package org.fobework.musicbookingapi.services.implementation;

import org.fobework.musicbookingapi.data.Repo.ArtistRepository;
import org.fobework.musicbookingapi.data.model.Artist;
import org.fobework.musicbookingapi.dto.ArtistDto;
import org.fobework.musicbookingapi.dto.CreateArtistDto;
import org.fobework.musicbookingapi.services.Interface.ArtistInterface;
import org.fobework.musicbookingapi.util.AutoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService implements ArtistInterface {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<ArtistDto> getAllArtists() {
        List<ArtistDto> artistDtos = new ArrayList<>();
        List<Artist> artists = artistRepository.findAll();
        for (Artist artist : artists) {
            ArtistDto artistDto = new ArtistDto();
            AutoMapper.mapper(artist, artistDto);
            artistDtos.add(artistDto);
        }
        return artistDtos;
    }

    public ArtistDto getArtistById(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        ArtistDto artistDto = new ArtistDto();
        AutoMapper.mapper(artist, artistDto);
        return artistDto;
    }

    public ArtistDto createArtist(CreateArtistDto createArtistDto) {
        Artist artist = new Artist();
        AutoMapper.mapper(artist,createArtistDto);
        artistRepository.save(artist);
        ArtistDto artistDto = new ArtistDto();
        AutoMapper.mapper(artist, artistDto);
        return artistDto;
    }

    public ArtistDto updateArtist(Long id, CreateArtistDto artistDetails) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
        AutoMapper.mapper(artist,artistDetails);
        artistRepository.save(artist);
        ArtistDto artistDto = new ArtistDto();
        AutoMapper.mapper(artist, artistDto);
        return artistDto;
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}

