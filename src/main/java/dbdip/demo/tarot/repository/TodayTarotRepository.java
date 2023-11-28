package dbdip.demo.tarot.repository;

import dbdip.demo.tarot.entity.TodayTarot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodayTarotRepository extends JpaRepository<TodayTarot, Integer> {
}
