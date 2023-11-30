package vn.com.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vn.com.edu.iuh.fit.backend.model.Post;
import vn.com.edu.iuh.fit.backend.services.PostService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private PostService postService;

    @GetMapping( "/")
    public  String index(Model model){
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping(value = "/posts")
    public List<Post> posts(){
        return postService.getAllPost();
    }

    @PostMapping(value = "/post")
    public void publishPost(@RequestBody Post post){
        postService.insert(post);
    }

}
