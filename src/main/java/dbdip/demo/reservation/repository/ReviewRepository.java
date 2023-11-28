package dbdip.demo.reservation.repository;

import dbdip.demo.reservation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "select distinct R " +
            "from Review R inner join R.reservation V on R.reservation.id = V.id " +
            "where V.experts.id = :expert")
    List<Review> findAllByExperts(@Param(value = "expert") Integer expertsId);
}
