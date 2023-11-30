package vn.com.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.edu.iuh.fit.backend.model.PostComment;


public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
