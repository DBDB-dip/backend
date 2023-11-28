package dbdip.demo.reservation.dto;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.users.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class ReservationDto {
    @Schema(description = "id")
    private int id;
    @Schema(description = "userId")
    private int userId;
    @Schema(description = "userName")
    private String userName;
    @Schema(description = "expertsId")
    private int expertsId;
    @Schema(description = "expertsName")
    private String expertsName;
    @Schema(description = "reservDate")
    private LocalDate reservDate;
    @Schema(description = "reservTime")
    private int reservTime;
    public ReservationDto(Reservation reservation){
        this.id = reservation.getId();
        this.userId = reservation.getUsers().getId();
        this.userName = reservation.getUsers().getName();
        this.expertsId = reservation.getExperts().getId();
        this.expertsName = reservation.getExperts().getName();
        this.reservDate = reservation.getReservDate();
        this.reservTime = reservation.getReservTime();
    }
}
