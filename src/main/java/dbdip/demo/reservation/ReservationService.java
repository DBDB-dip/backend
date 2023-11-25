package dbdip.demo.reservation;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.expert.repository.ExpertsRepository;
import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.reservation.entity.Review;
import dbdip.demo.reservation.repository.ReservationRepository;
import dbdip.demo.reservation.repository.ReviewRepository;
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
    private final ReviewRepository reviewRepository;
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
    @Transactional
    public void createReview(Integer reservationId, String comments, Float starRate) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);

        if (reservation != null) {
            Review review = Review.builder()
                    .reservation(reservation)
                    .comments(comments)
                    .starRate(starRate)
                    .build();

            reviewRepository.save(review);
        }
    }

}
