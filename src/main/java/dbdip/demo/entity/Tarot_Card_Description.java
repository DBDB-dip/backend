package dbdip.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarot_Card_Description {
    @Id
    private Integer CardId;
    private Integer Card;
    private String Description;
}
