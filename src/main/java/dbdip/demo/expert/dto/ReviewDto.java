package dbdip.demo.expert.dto;

import dbdip.demo.reservation.entity.Reservation;
import dbdip.demo.reservation.entity.Review;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ReviewDto {
    @Schema(description = "id")
    private int id;
    @Schema(description = "comments")
    private String comments;
    @Schema(description = "starRate")
    private float starRate;
    public ReviewDto(Review review){
        this.id = review.getId();
        this.comments = review.getComments();
        this.starRate = review.getStarRate();
    }
}
