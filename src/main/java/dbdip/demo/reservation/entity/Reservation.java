package dbdip.demo.reservation.entity;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Entity
@Slf4j
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservid")
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
