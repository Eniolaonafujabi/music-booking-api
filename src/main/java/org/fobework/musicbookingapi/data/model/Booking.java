package org.fobework.musicbookingapi.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private LocalDateTime bookingTime;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
