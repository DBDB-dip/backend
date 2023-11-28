package dbdip.demo.tarot.entity;

import dbdip.demo.users.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TodayTarotId implements Serializable {
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "tarotdate")
    private LocalDate tarotDate;

}