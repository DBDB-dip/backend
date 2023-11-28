package dbdip.demo.expert.dto;

import dbdip.demo.expert.entity.Consult;
import dbdip.demo.expert.entity.Experts;
import dbdip.demo.expert.entity.Stores;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ExpertsDto {
    @Schema(description = "id")
    private int id;
    @Schema(description = "name")
    private String name;
    @Schema(description = "phonenumber")
    private String phoneNumber;
    @Schema(description = "age")
    private Integer age;
    @Schema(description = "email")
    private String email;
    @Schema(description = "career")
    private Integer career;
    @Schema(description = "sex")
    private char sex;
    public ExpertsDto(Experts experts){
        this.id = experts.getId();
        this.name = experts.getName();
        this.phoneNumber = experts.getPhoneNumber();
        this.age = experts.getAge();
        this.email = experts.getEmail();
        this.career = experts.getCareer();
        this.sex = experts.getSex();
    }
}
