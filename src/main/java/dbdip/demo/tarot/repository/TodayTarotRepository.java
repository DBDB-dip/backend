package dbdip.demo.tarot.repository;

import dbdip.demo.tarot.entity.TodayTarot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayTarotRepository extends JpaRepository<TodayTarot, Integer> {
}
