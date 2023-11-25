package dbdip.demo.reservation.repository;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByExperts(Experts experts);
}
