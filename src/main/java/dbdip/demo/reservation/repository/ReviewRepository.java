package dbdip.demo.reservation.repository;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT R, E.id " +
            "FROM Review R , Reservation V, Experts E " +
            "WHERE R.reservation.id = V.id " +
            "AND V.experts.id = E.id " +
            "AND E.id = :expert")
    List<Review> findAllByExperts(@Param(value = "expert") Integer expertsId);
}
