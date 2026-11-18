package ie.atu.sample.service;

import ie.atu.sample.dto.BookingRequestDto;
import ie.atu.sample.dto.BookingResponseDto;
import ie.atu.sample.exception.CapacityExceededException;
import ie.atu.sample.exception.NotFoundException;
import ie.atu.sample.model.Booking;
import ie.atu.sample.model.BookingStatus;
import ie.atu.sample.model.Room;
import ie.atu.sample.repository.BookingRepository;
import ie.atu.sample.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    public BookingResponseDto create(BookingRequestDto request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new NotFoundException("Room not found with id " + request.getRoomId()));

        if (request.getAttendeeCount() > room.getCapacity()) {
            throw new CapacityExceededException(
                    "attendeeCount " + request.getAttendeeCount()
                            + " exceeds capacity " + room.getCapacity()
                            + " for room " + room.getName());
        }

        Booking booking = new Booking();
        booking.setOrganiserName(request.getOrganiserName());
        booking.setAttendeeCount(request.getAttendeeCount());
        booking.setRoom(room);
        booking.setStatus(BookingStatus.ACTIVE);

        return BookingResponseDto.from(bookingRepository.save(booking));
    }

    @Transactional(readOnly = true)
    public BookingResponseDto getById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found with id " + id));
        return BookingResponseDto.from(booking);
    }

    @Transactional(readOnly = true)
    public List<BookingResponseDto> searchByRoomName(String roomName) {
        return bookingRepository.findByRoomNameExact(roomName).stream()
                .map(BookingResponseDto::from)
                .toList();
    }
}