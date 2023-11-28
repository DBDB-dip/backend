package dbdip.demo.expert;

import dbdip.demo.expert.dto.ExpertsDto;
import dbdip.demo.expert.repository.ExpertsRepository;
import dbdip.demo.reservation.entity.Review;
import dbdip.demo.reservation.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpertsService {
    private final ExpertsRepository expertsRepository;
    private final ReviewRepository reviewRepository;

    public List<ExpertsDto> filterExperts(String field, Integer minPrice, Integer maxPrice, String city) {
        // 상담분야, 최소 금액, 최대 금액, 지역에 따라 전문가 필터링하기
        if (field != null && minPrice != null && maxPrice != null && city != null) {
            return expertsRepository.findByFieldAndPriceHourBetweenAndCity(field, minPrice, maxPrice, city).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else if (field != null && minPrice != null && maxPrice != null) {
            return expertsRepository.findByFieldAndPriceHourBetween(field, minPrice, maxPrice).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else if (field != null && city != null) {
            return expertsRepository.findByFieldAndCity(field, city).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else if (minPrice != null && maxPrice != null && city != null) {
            return expertsRepository.findByPriceHourBetweenAndCity(minPrice, maxPrice, city).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else if (field != null) {
            return expertsRepository.findByField(field).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else if (minPrice != null && maxPrice != null) {
            return expertsRepository.findByPriceHourBetween(minPrice, maxPrice).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else if (city != null) {
            return expertsRepository.findByCity(city).stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        } else {
            return expertsRepository.findAll().stream()
                    .map(ExpertsDto::new)
                    .collect(Collectors.toList());
        }
    }

    public List<Review> getAllReviewsForExpert(Integer expertId) {
        return reviewRepository.findAllByExperts(expertId);
    }
}