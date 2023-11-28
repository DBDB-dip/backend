package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Experts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertsRepository extends JpaRepository<Experts, Integer> {
    @Query(value = "SELECT e FROM Experts e JOIN e.consult c " +
            "WHERE c.field = :field")
    List<Experts> findByField(@Param("field") String field);
    @Query(value = "SELECT e FROM Experts e JOIN e.consult c " +
            "WHERE c.priceHour BETWEEN :min_price AND :max_price")
    List<Experts> findByPriceHourBetween(@Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice);
    @Query(value = "SELECT e FROM Experts e JOIN e.store s " +
            "WHERE s.city = :city")
    List<Experts> findByCity(@Param("city") String city);
    @Query(value = "SELECT e FROM Experts e JOIN e.consult c " +
            "WHERE c.field = :field " +
            "AND c.priceHour BETWEEN :min_price AND :max_price")
    List<Experts> findByFieldAndPriceHourBetween(@Param("field") String field, @Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice);
    @Query("SELECT e FROM Experts e JOIN e.store s JOIN e.consult c " +
            "WHERE c.field = :field AND s.city = :city")
    List<Experts> findByFieldAndCity(@Param("field") String field, @Param("city") String city);
    @Query(value = "SELECT e FROM Experts e JOIN e.store s JOIN e.consult c " +
            "WHERE c.priceHour BETWEEN :min_price AND :max_price " +
            "AND s.city = :city")
    List<Experts> findByPriceHourBetweenAndCity(@Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice, @Param("city") String city);
    @Query(value = "SELECT e FROM Experts e JOIN e.store s JOIN e.consult c " +
            "WHERE c.priceHour BETWEEN :min_price AND :max_price " +
            "AND s.city = :city " +
            "AND c.field = :field")
    List<Experts> findByFieldAndPriceHourBetweenAndCity(@Param("field")String field, @Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice, @Param("city") String city);
}
