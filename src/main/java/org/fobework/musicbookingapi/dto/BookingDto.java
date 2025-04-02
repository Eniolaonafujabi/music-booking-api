package org.fobework.musicbookingapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.fobework.musicbookingapi.data.model.Event;

import java.time.LocalDateTime;

@Setter
@Getter
public class BookingDto {
    private Long id;

    private String customerName;
    private LocalDateTime bookingTime;

    private Event event;
}

