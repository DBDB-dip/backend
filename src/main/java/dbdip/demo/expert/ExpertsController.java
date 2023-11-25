package dbdip.demo.expert;

import dbdip.demo.expert.entity.Experts;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertsController {
    private final ExpertsService expertsService;
    @GetMapping("/filter")
    public List<Experts> filterExperts(
            @RequestParam(required = false) String field,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String city
    ) {
        return expertsService.filterExperts(field, minPrice, maxPrice, city);
    }
}
