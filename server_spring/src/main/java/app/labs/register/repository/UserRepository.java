package app.labs.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.labs.register.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
