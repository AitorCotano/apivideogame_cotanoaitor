package cat.itb.projecte1.apiusuaris.model.repositoris;

import cat.itb.projecte1.apiusuaris.model.entitats.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
