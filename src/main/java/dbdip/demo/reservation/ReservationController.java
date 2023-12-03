package dbdip.demo.reservation;
import dbdip.demo.reservation.dto.ReservationDto;
import dbdip.demo.reservation.entity.ReservationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
    @PostMapping // OK
    public ResponseEntity<String> createReservation(
            @RequestParam("userId") Integer userId,
            @RequestParam("expertId") Integer expertId,
            @RequestParam("reservDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate reservDate,
            @RequestParam("reservTime") Integer reservTime
    ) {
        reservationService.createReservation(userId, expertId, reservDate, reservTime);

        return new ResponseEntity<>("Reservation created successfully", HttpStatus.CREATED);
    }
    @PostMapping("/day")
    public ResponseEntity<String> createReservationByDay(
            @RequestParam("userId") Integer userId,
            @RequestParam("expertId") Integer expertId,
            @RequestParam("reservDay") Integer reservDay,
            @RequestParam("reservTime") Integer reservTime
    ) {
        reservationService.createReservationByDay(userId, expertId, reservDay, reservTime);

        return new ResponseEntity<>("Reservation created successfully", HttpStatus.CREATED);
    }
    @GetMapping // OK
    public ResponseEntity<List<ReservationDto>> getAllReservationByUser(
            @RequestParam("userId") Integer userId
    ) {
        return new ResponseEntity<>(reservationService.getAllReservation(userId), HttpStatus.OK);
    }
    @GetMapping("/") // OK
    public ResponseEntity<List<ReservationDto>> getReservationsByStatus(
            @RequestParam("userId") Integer userId,
            @RequestParam("status") String status) {

        ReservationStatus r = null;

        if(status.equals("before"))
        {
            r =ReservationStatus.BEFORE_TODAY;
        }

        else if(status.equals("after"))
        {
            r = ReservationStatus.AFTER_TODAY;
        }

        else {
            r = ReservationStatus.TODAY;
        }

        return new ResponseEntity<>(reservationService.filterReservationsByStatus(userId, r), HttpStatus.OK);
    }
    @PostMapping("/reviews") // OK
    public ResponseEntity<String> createReview(
            @RequestParam("reservationId") Integer reservationId,
            @RequestParam("comments") String comments,
            @RequestParam("starRate") Float starRate
    ) {
        reservationService.createReview(reservationId, comments, starRate);

        return new ResponseEntity<>("Review created successfully", HttpStatus.CREATED);
    }
}
