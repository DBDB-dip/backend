package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Password;
    private String Name;
    private String PhoneNumber;
    private String Email;
    private char Sex;
    private LocalDate Birthdate;
}
