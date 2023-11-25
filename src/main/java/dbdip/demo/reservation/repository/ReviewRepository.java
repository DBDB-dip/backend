package dbdip.demo.reservation.repository;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT Review.*, Experts.Eid\n" +
            "FROM Review, Reservation, Experts\n" +
            "WHERE REVIEW.ReservId = Reservation.ReservId\n" +
            "AND Reservation.ExpertId = Experts.Eid\n" +
            "AND Experts.Eid = ?")
    List<Review> findAllByExperts(Integer expertsId);
}
