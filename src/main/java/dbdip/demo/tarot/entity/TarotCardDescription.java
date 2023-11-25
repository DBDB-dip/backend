package dbdip.demo.tarot.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Table(name = "TAROT_CARD_DESCRIPTION")
public class TarotCardDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardid")
    private Integer id;
    @Column(name = "card")
    private Integer card;
    @Column(name = "description")
    private String description;
}
