package dbdip.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Today_tarot {

    @Column(name = "userid")
    private Integer UserId;
    @Column(name = "tarotdata")
    private LocalDate TarotDate;
    @Column(name = "carddescriptionid")
    private Integer CardDescriptionId;
}
