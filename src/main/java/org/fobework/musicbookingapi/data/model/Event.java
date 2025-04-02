package org.fobework.musicbookingapi.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private LocalDateTime eventDate;

    // Many events can be hosted by one artist
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
