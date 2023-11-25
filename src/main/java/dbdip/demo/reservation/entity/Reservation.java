package dbdip.demo.reservation.entity;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.users.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "userid")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "expertid")
    private Experts experts;
    @Column(name = "reservdate")
    private LocalDate reservDate;
    @Column(name = "reservtime")
    private Integer reservTime;
}
