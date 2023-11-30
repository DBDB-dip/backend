package dbdip.demo.users.repository;

import dbdip.demo.users.dto.UsersDto;
import dbdip.demo.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByEmailAndPassword(String email, String password);
    List<Users> findByEmail(String email);

    // Integer findMaxId();
}
