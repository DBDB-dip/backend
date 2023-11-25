package dbdip.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Today_tarot {
    private Integer UserId;
    private LocalDate TarotDate;
    private Integer CardDescriptionId;
}
