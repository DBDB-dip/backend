package dbdip.demo.expert;

import dbdip.demo.expert.dto.ExpertsDto;
import dbdip.demo.expert.dto.ReviewDto;
import dbdip.demo.expert.dto.WorkAtDto;
import dbdip.demo.reservation.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertsController {
    private final ExpertsService expertsService;
    @GetMapping("/filter") //OK
    public List<ExpertsDto> filterExperts(
            @RequestParam(value="field", required = false) String field,
            @RequestParam(value="minPrice", required = false) Integer minPrice,
            @RequestParam(value="maxPrice", required = false) Integer maxPrice,
            @RequestParam(value="city", required = false) String city
    ) {
        return expertsService.filterExperts(field, minPrice, maxPrice, city);
    }
    @GetMapping("/{expertsId}") //OK
    public ResponseEntity<List<WorkAtDto>> getExpertsConsultSchedule(
            @PathVariable(name = "expertsId") Integer expertsId
    ) {
        return new ResponseEntity<>(
                expertsService.getExpertsWorkAtSchedule(expertsId), HttpStatus.OK);
    }
    @GetMapping("/{expertId}/reviews") // OK
    public ResponseEntity<List<ReviewDto>> getAllReviewsForExpert(@PathVariable("expertId") Integer expertId) {
        List<ReviewDto> reviews = expertsService.getAllReviewsForExpert(expertId);

        if (reviews != null && !reviews.isEmpty()) {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
