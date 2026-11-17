package ie.atu.sample.dto;

import ie.atu.sample.model.Booking;
import ie.atu.sample.model.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingResponseDto {
    private Long id;
    private Long roomId;
    private String roomName;
    private String organiserName;
    private int attendeeCount;
    private BookingStatus status;

    public static BookingResponseDto from(Booking booking) {
        return new BookingResponseDto(
                booking.getId(),
                booking.getRoom().getId(),
                booking.getRoom().getName(),
                booking.getOrganiserName(),
                booking.getAttendeeCount(),
                booking.getStatus()
        );
    }
}
