package com.project.faisabot.Controller;


import com.project.faisabot.Repository.ForumRepo;
import com.project.faisabot.Repository.UserRepo;
import com.project.faisabot.model.Forum;
import com.project.faisabot.model.User;
import jakarta.servlet.http.HttpSession;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private UserRepo userrepo ;
    @Autowired
    private ForumRepo forumRepo ;

    @GetMapping("/Users")
    public List<User> users(HttpSession session){

        return userrepo.findAll();

    }

    @PostMapping("/AdminProfile")
    public User profile (@RequestBody  User newuser,  HttpSession session){
        User curuser = (User) session.getAttribute("Admin");
        newuser.setId(curuser.getId());
        return userrepo.save(newuser);
    }
    @PostMapping("/Forums")
    public List<Forum> Forums(){
        List<Forum> forumList = forumRepo.findAll();
        for (Forum forum: forumList) {
            User newuser = userrepo.findById(forum.getForum_user().getId()).get();

            forum.setForum_user(newuser);
            
        }
        return forumList;
    }
}
