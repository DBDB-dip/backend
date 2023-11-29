package dbdip.demo.users.dto;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.users.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UsersDto {
    @Schema(description = "id")
    private int id;
    @Schema(description = "name")
    private String name;
    @Schema(description = "phonenumber")
    private String phoneNumber;
    @Schema(description = "email")
    private String email;
    @Schema(description = "sex")
    private char sex;
    @Schema(description = "birthDate")
    private LocalDate birthDate;

    public UsersDto(Users user){
        this.id = user.getId();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.sex = user.getSex();
        this.birthDate = user.getBirthdate();
    }
}
