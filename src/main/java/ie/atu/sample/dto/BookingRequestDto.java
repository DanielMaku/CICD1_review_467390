package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingRequestDto {
    @NotNull(message = "room id is needed")
    private Long roomId;

    @NotBlank(message = "organisers name cant be blank")
    @Size(min = 2, max = 60, message = "organiserName must be 2-60 characters")
    private String organiserName;

    @Positive(message = "attendee count must be a positive number")
    private int attendeeCount;
}
