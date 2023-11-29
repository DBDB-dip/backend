package dbdip.demo.users.entity;

import dbdip.demo.reservation.entity.Reservation;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private char sex;
    @Column(name = "birthdate")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<Reservation>();
}
