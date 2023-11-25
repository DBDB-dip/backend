package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Integer> {
}
