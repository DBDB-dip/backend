package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Experts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertsRepository extends JpaRepository<Experts, Integer> {
    @Query(value = "SELECT e FROM Experts e " +
            "INNER JOIN Consult c ON e.id = c.id " +
            "WHERE c.field = :field")
    List<Experts> findByField(@Param("field") String field);
    @Query(value = "SELECT e FROM Experts e " +
            "INNER JOIN Consult c ON e.id = c.id " +
            "WHERE c.priceHour BETWEEN :min_price AND :max_price")
    List<Experts> findByPriceHourBetween(@Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice);
    @Query(value = "SELECT e FROM Experts e " +
            "INNER JOIN Stores s ON e.id = s.id " +
            "WHERE s.city = :city")
    List<Experts> findByCity(@Param("city") String city);
    @Query(value = "SELECT e FROM Experts e, Consult c " +
            "WHERE e.id = c.id " +
            "AND c.field = :field " +
            "AND c.priceHour BETWEEN :min_price AND :max_price")
    List<Experts> findByFieldAndPriceHourBetween(@Param("field") String field, @Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice);
    @Query(value = "SELECT e FROM Experts e, Stores s, Consult c " +
            "WHERE e.id = s.id AND e.id = c.id " +
            "AND c.field = :field AND s.city = :city")
    List<Experts> findByFieldAndCity(@Param("field") String field, @Param("city") String city);
    @Query(value = "SELECT E FROM Experts E, Stores S, Consult C " +
            "WHERE E.id = S.id AND E.id = C.id " +
            "AND C.priceHour BETWEEN :min_price AND :max_price " +
            "AND S.city = :city")
    List<Experts> findByPriceHourBetweenAndCity(@Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice, @Param("city") String city);
    @Query(value = "SELECT E FROM Experts E, Stores S, Consult C " +
            "WHERE E.id = S.id AND E.id = C.id " +
            "AND C.priceHour BETWEEN :min_price AND :max_price " +
            "AND S.city = :city " +
            "AND C.field = :field")
    List<Experts> findByFieldAndPriceHourBetweenAndCity(@Param("field")String field, @Param("min_price") Integer minPrice, @Param("max_price") Integer maxPrice, @Param("city") String city);
}
