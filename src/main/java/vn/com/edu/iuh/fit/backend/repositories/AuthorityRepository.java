package vn.com.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.edu.iuh.fit.backend.model.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
