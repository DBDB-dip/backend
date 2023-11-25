package dbdip.demo.reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
