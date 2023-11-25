package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Experts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertsRepository extends JpaRepository<Experts, Integer> {
}
