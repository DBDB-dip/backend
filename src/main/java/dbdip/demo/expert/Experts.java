package dbdip.demo.expert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer id;
    private String name;
    private String phoneNumber;
    private Integer age;
    private String email;
    private Integer career;
    private Character Sex;
}
