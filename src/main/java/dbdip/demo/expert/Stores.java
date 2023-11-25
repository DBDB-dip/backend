package dbdip.demo.expert;

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
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private int id;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "eid")
    private Experts experts;

}
