package dbdip.demo.users.repository;

import dbdip.demo.users.dto.UsersDto;
import dbdip.demo.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByEmailAndPassword(String email, String password);
    List<Users> findByEmail(String email);

    @Query("SELECT MAX(u.id) FROM Users u")
    Integer findMaxId();
}
