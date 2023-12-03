package dbdip.demo.expert.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "WORK_AT")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class WorkAt {

    @EmbeddedId
    private WorkAtId id;

    @ManyToOne
    @JoinColumn(name = "eid", insertable = false, updatable = false)
    private Experts expert;

    @Column(name = "start_time")
    private Integer startTime;

    @Column(name = "end_time")
    private Integer endTime;

}