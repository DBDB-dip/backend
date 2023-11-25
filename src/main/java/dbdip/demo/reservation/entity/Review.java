package dbdip.demo.reservation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer id;
    @OneToOne
    @Column(name = "reservid")
    private Reservation reservation;
    @Column(name = "comments")
    private String Comments;
    @Column(name = "starrate")
    private Float StarRate;
}