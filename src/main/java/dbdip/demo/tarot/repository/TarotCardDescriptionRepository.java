package dbdip.demo.tarot.repository;

import dbdip.demo.tarot.entity.TarotCardDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarotCardDescriptionRepository extends JpaRepository<TarotCardDescription, Integer> {
}
