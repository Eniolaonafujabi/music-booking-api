package org.fobework.musicbookingapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateBookingDto {
    private String customerName;
    private LocalDateTime bookingTime;
}
