package dbdip.demo.expert.repository;

import dbdip.demo.expert.entity.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoresRepository extends JpaRepository<Stores, Integer> {
}
