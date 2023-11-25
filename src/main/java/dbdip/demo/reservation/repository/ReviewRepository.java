package dbdip.demo.reservation.repository;

import dbdip.demo.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
