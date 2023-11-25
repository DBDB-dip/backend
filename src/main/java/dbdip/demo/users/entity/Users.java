package dbdip.demo.users.entity;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "password")
    private String Password;
    @Column(name = "name")
    private String Name;
    @Column(name = "phonenumber")
    private String PhoneNumber;
    @Column(name = "email")
    private String Email;
    @Column(name = "sex")
    private char Sex;
    @Column(name = "birthdate")
    private LocalDate Birthdate;
}
