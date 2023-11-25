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

    public List<Experts> filterExperts(String field, Double price, String city) {
        // 상담분야, 요금, 지역에 따라 전문가 필터링하기
        if (field != null && price != null && city != null) {
            return expertsRepository.findByFieldAndPriceAndCity(field, price, city);
        } else if (field != null && price != null) {
            return expertsRepository.findByFieldAndPrice(field, price);
        } else if (field != null && city != null) {
            return expertsRepository.findByFieldAndCity(field, city);
        } else if (price != null && city != null) {
            return expertsRepository.findByPriceAndCity(price, city);
        } else if (field != null) {
            return expertsRepository.findByField(field);
        } else if (price != null) {
            return expertsRepository.findByPrice(price);
        } else if (city != null) {
            return expertsRepository.findByCity(city);
        } else {
            return expertsRepository.findAll();
        }
    }

}
