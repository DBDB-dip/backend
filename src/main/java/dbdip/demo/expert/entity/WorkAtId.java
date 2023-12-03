package dbdip.demo.expert.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WorkAtId implements Serializable {

    @Column(name = "eid")
    private Integer eid;

    @Column(name = "workday")
    private String workDay;

}