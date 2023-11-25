package dbdip.demo.tarot.repository;

import dbdip.demo.tarot.entity.TarotCardDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarotCardDescriptionRepository extends JpaRepository<TarotCardDescription, Integer> {
}
