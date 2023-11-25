package dbdip.demo.reservation.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "reservid")
    private Reservation reservation;
    @Column(name = "comments")
    private String comments;
    @Column(name = "starrate")
    private Float starRate;
}