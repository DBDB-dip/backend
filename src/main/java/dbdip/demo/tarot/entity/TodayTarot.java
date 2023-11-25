package dbdip.demo.tarot.entity;

import dbdip.demo.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Table(name = "TODAY_TAROT")
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class TodayTarot {

    @EmbeddedId
    private TodayTarotId id;

    @ManyToOne
    @JoinColumn(name = "CardDescriptionId")
    private TarotCardDescription cardDescription;

}