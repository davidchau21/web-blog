package vn.com.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.com.edu.iuh.fit.backend.model.Post;
import vn.com.edu.iuh.fit.backend.model.User;
import vn.com.edu.iuh.fit.backend.services.PostService;
import vn.com.edu.iuh.fit.backend.services.UserService;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        }else {
            return "error";
        }
    }

    @GetMapping("/posts/new")
    public String createNewPost(Model model) {
        Optional<User> optionalUser =  userService.findByEmail( "jane@example.com");
        if (optionalUser.isPresent()){
            Post post = new Post();
            post.setUser(optionalUser.get());
            model.addAttribute("post", post);
            return "post_new";
        }else {
            return "404";
        }
    }

    @PostMapping("/posts/new")
    public String createPost(@ModelAttribute Post post){
        postService.insert(post);
        return "redirect:/posts/" + post.getId();
    }
}
