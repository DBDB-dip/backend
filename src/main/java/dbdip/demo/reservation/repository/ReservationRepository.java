package dbdip.demo.reservation.repository;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByUsers(Users users);
    @Query("SELECT COUNT(r) > 0 FROM Reservation r WHERE r.experts = :expert AND r.reservDate = :reservDate AND r.reservTime = :reservTime")
    boolean existsByExpertsAndReservDateAndReservTime(@Param("expert") Experts expert, @Param("reservDate") LocalDate reservDate, @Param("reservTime") Integer reservTime);
    @Query("SELECT COUNT(r) > 0 FROM Reservation r WHERE r.users = :user AND r.reservDate = :reservDate AND r.reservTime = :reservTime")
    boolean existsByUsersAndReservDateAndReservTime(@Param("user") Users users, @Param("reservDate") LocalDate reservDate, @Param("reservTime") Integer reservTime);
}
