package dbdip.demo.reservation;
import dbdip.demo.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping
    public ResponseEntity<String> createReservation(
            @RequestParam("userId") Integer userId,
            @RequestParam("expertId") Integer expertId,
            @RequestParam("reservDate") LocalDate reservDate,
            @RequestParam("reservTime") Integer reservTime
    ) {
        reservationService.createReservation(userId, expertId, reservDate, reservTime);

        return new ResponseEntity<>("Reservation created successfully", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservationByUser(
            @RequestParam("userId") Integer userId
    ) {
        return new ResponseEntity<>(reservationService.getAllReservation(userId), HttpStatus.OK);
    }
    @GetMapping("/before")
    public ResponseEntity<List<ReservationDto>> getAllReservationByUserAndBeforeToday(
            @RequestParam("userId") Integer userId
    ) {
        return new ResponseEntity<>(reservationService.getAllReservationBeforeToday(userId), HttpStatus.OK);
    }
    @GetMapping("/after")
    public ResponseEntity<List<ReservationDto>> getAllReservationByUserAndAfterToday(
            @RequestParam("userId") Integer userId
    ) {
        return new ResponseEntity<>(reservationService.getAllReservationAfterToday(userId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(
            @RequestParam("reservationId") Integer reservationId,
            @RequestParam("comments") String comments,
            @RequestParam("starRate") Float starRate
    ) {
        reservationService.createReview(reservationId, comments, starRate);

        return new ResponseEntity<>("Review created successfully", HttpStatus.CREATED);
    }
}
