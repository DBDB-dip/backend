package dbdip.demo.reservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "reservid")
    private Reservation reservation;
    @Column(name = "comments")
    private String Comments;
    @Column(name = "starrate")
    private Float StarRate;
}