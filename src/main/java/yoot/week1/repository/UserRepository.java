package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
