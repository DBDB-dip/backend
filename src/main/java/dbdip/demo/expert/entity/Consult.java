package dbdip.demo.expert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Table(name = "Consult")
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer id;
    @Column(name = "field")
    private String field;
    @Column(name = "price_hour")
    private Double priceHour;

    @ManyToOne
    @JoinColumn(name = "eid")
    private Experts experts;
}
