package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Experts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpertsRepository extends JpaRepository<Experts, Integer> {
    List<Experts> findByField(String field);

    List<Experts> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Experts> findByCity(String city);

    List<Experts> findByFieldAndPriceBetween(String field, Double minPrice, Double maxPrice);

    List<Experts> findByFieldAndCity(String field, String city);

    List<Experts> findByPriceBetweenAndCity(Double minPrice, Double maxPrice, String city);

    List<Experts> findByFieldAndPriceBetweenAndCity(String field, Double minPrice, Double maxPrice, String city);
}
