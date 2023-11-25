package dbdip.demo.reservation.repository;

import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByUsers(Users users);

}
