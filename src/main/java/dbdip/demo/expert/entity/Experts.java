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
public class Experts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;
    @Column(name = "career")
    private Integer career;
    @Column(name = "sex")
    private Character sex;

    @OneToOne(mappedBy = "experts", cascade = CascadeType.ALL)
    private Stores store;
    @OneToOne(mappedBy = "experts", cascade = CascadeType.ALL)
    private Consult consult;


}
