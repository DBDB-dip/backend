package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Experts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpertsRepository extends JpaRepository<Experts, Integer> {
    List<Experts> findByField(String field);

    List<Experts> findByPrice(Double price);

    List<Experts> findByCity(String city);

    List<Experts> findByFieldAndPrice(String field, Double price);

    List<Experts> findByFieldAndCity(String field, String city);

    List<Experts> findByPriceAndCity(Double price, String city);

    List<Experts> findByFieldAndPriceAndCity(String field, Double price, String city);
}
