package dbdip.demo.reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping("/create")
    public void createReservation(
            @RequestParam("userId") Integer userId,
            @RequestParam("expertId") Integer expertId,
            @RequestParam("reservDate") LocalDate reservDate,
            @RequestParam("reservTime") Integer reservTime
    ) {
        reservationService.createReservation(userId, expertId, reservDate, reservTime);
    }
}
