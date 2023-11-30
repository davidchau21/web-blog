package vn.com.edu.iuh.fit.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.edu.iuh.fit.backend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String mail);
}
