package ie.atu.sample.controller;

import ie.atu.sample.dto.BookingRequestDto;
import ie.atu.sample.dto.BookingResponseDto;
import ie.atu.sample.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDto> create(@Valid @RequestBody BookingRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookingResponseDto>> search(@RequestParam String roomName) {
        return ResponseEntity.ok(bookingService.searchByRoomName(roomName));
    }
}