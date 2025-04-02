package org.fobework.musicbookingapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateArtistDto {
    private String name;
    private String genre;
    private String bio;
}
