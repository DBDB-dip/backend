package dbdip.demo.reservation;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.expert.repository.ExpertsRepository;
import dbdip.demo.reservation.dto.ReservationDto;
import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.reservation.entity.ReservationStatus;
import dbdip.demo.reservation.entity.Review;
import dbdip.demo.reservation.repository.ReservationRepository;
import dbdip.demo.reservation.repository.ReviewRepository;
import dbdip.demo.users.entity.Users;
import dbdip.demo.users.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReviewRepository reviewRepository;
    private final ExpertsRepository expertsRepository;
    private final UsersRepository usersRepository;
    @Transactional
    public void createReservation(Integer userId, Integer expertId, LocalDate reservDate, Integer reservTime) {
        Users user = usersRepository.findById(userId).orElse(null);
        Experts expert = expertsRepository.findById(expertId).orElse(null);
        log.info("{}, {}, {}, {}", userId, expertId, reservDate, reservTime);


        if (user != null && expert != null) {
            log.info("{}, {}", user.getName(), expert.getName());
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
            log.info(String.valueOf(review.getId()));

            reviewRepository.save(review);
        }
    }
    public List<ReservationDto> getAllReservation(Integer userId){
        Users users = usersRepository.findById(userId).orElse(null);
        return reservationRepository.findAllByUsers(users).stream()
                .map(ReservationDto::new)
                .collect(Collectors.toList());
    }
    public List<ReservationDto> filterReservationsByStatus(Integer userId, ReservationStatus status) {
        Users users = usersRepository.findById(userId).orElse(null);

        // 해당 상태에 해당하는 예약만 필터링하여 반환
        return reservationRepository.findAllByUsers(users).stream()
                .filter(reservation -> reservation.getStatus() == status)
                .map(ReservationDto::new)
                .collect(Collectors.toList());
    }

}
