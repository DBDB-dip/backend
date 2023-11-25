package dbdip.demo.expert;

import dbdip.demo.expert.entity.Experts;
import dbdip.demo.expert.repository.ExpertsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertsService {
    private final ExpertsRepository expertsRepository;

    public List<Experts> filterExperts(String field, Double minPrice, Double maxPrice, String city) {
        // 상담분야, 최소 금액, 최대 금액, 지역에 따라 전문가 필터링하기
        if (field != null && minPrice != null && maxPrice != null && city != null) {
            return expertsRepository.findByFieldAndPriceBetweenAndCity(field, minPrice, maxPrice, city);
        } else if (field != null && minPrice != null && maxPrice != null) {
            return expertsRepository.findByFieldAndPriceBetween(field, minPrice, maxPrice);
        } else if (field != null && city != null) {
            return expertsRepository.findByFieldAndCity(field, city);
        } else if (minPrice != null && maxPrice != null && city != null) {
            return expertsRepository.findByPriceBetweenAndCity(minPrice, maxPrice, city);
        } else if (field != null) {
            return expertsRepository.findByField(field);
        } else if (minPrice != null && maxPrice != null) {
            return expertsRepository.findByPriceBetween(minPrice, maxPrice);
        } else if (city != null) {
            return expertsRepository.findByCity(city);
        } else {
            return expertsRepository.findAll();
        }
    }

}
