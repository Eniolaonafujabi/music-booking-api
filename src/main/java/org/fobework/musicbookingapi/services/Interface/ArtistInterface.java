package org.fobework.musicbookingapi.services.Interface;

import org.fobework.musicbookingapi.dto.ArtistDto;
import org.fobework.musicbookingapi.dto.CreateArtistDto;

import java.util.List;

public interface ArtistInterface {

    List<ArtistDto> getAllArtists();

    ArtistDto getArtistById(Long id);

    ArtistDto createArtist(CreateArtistDto createArtistDto);

    ArtistDto updateArtist(Long id, CreateArtistDto artistDetails);

    void deleteArtist(Long id);

}
