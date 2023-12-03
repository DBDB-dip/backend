package dbdip.demo.expert.repository;

import dbdip.demo.expert.dto.WorkAtDto;
import dbdip.demo.expert.entity.Experts;
import dbdip.demo.expert.entity.WorkAt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkAtRepository extends JpaRepository<WorkAt, Integer> {
    List<WorkAt> findAllByExpert(Experts experts);
}
