package vn.com.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.edu.iuh.fit.backend.model.PostComment;
import vn.com.edu.iuh.fit.backend.repositories.PostCommentRepository;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;
    public void insert(PostComment postComment) {
        postCommentRepository.save(postComment);
    }
}
