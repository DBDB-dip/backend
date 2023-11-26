package dbdip.demo.reservation.repository;

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
    @Query(value = "SELECT R.experts.id, R.reservDate, R.reservTime " +
            "FROM Reservation R WHERE R.users.id = :usersId " +
            "AND R.reservDate <= :today")
    List<Reservation> findAllByUsersBeforeToday(@Param("usersId") Integer usersId, @Param("today") LocalDate today);
    @Query(value = "SELECT R.experts.id, R.reservDate, R.reservTime " +
            "FROM Reservation R WHERE R.users.id = :usersId " +
            "AND R.reservDate > :today")
    List<Reservation> findAllByUsersAfterToday(@Param("usersId") Integer usersId, @Param("today") LocalDate today);

}
