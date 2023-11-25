package dbdip.demo.reservation;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.expert.repository.ExpertsRepository;
import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.reservation.repository.ReservationRepository;
import dbdip.demo.users.entity.Users;
import dbdip.demo.users.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ExpertsRepository expertsRepository;
    private final UsersRepository usersRepository;
    @Transactional
    public void createReservation(Integer userId, Integer expertId, LocalDate reservDate, Integer reservTime) {
        Users user = usersRepository.findById(userId).orElse(null);
        Experts expert = expertsRepository.findById(expertId).orElse(null);

        if (user != null && expert != null) {
            final Reservation reservation = Reservation.builder()
                    .users(user)
                    .experts(expert)
                    .reservDate(reservDate)
                    .reservTime(reservTime)
                    .build();

            reservationRepository.save(reservation);
        }
    }

}
