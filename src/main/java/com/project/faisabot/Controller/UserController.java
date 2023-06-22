package com.project.faisabot.Controller;

import com.project.faisabot.Repository.ForumRepo;
import com.project.faisabot.Repository.UserRepo;
import com.project.faisabot.model.Forum;
import com.project.faisabot.model.User;
import jakarta.servlet.http.HttpSession;
//import org.jetbrains.annotations.NotNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepo userrepo ;
    @Autowired
    private ForumRepo forumRepo ;

    @PostMapping("/Inscrire")
    public User newUser(@RequestBody User user){

        return userrepo.save(user);
    }

    @PostMapping("/Profile")
    public User profile (@RequestBody  User newuser,  HttpSession session){
        User curuser = (User) session.getAttribute("User");
        newuser.setId(curuser.getId());
        return userrepo.save(newuser);
    }

    @PostMapping("/New_Forum")
    public Forum NewForum(@RequestBody Forum forum, HttpSession session){
        forum.setForum_user(new User());
        forum.getForum_user().setId(((User) session.getAttribute("User")).getId());
        return forumRepo.save(forum);
    }

    @PostMapping("/MyForums")
    public List<Forum> MyForums (HttpSession session){
        User user = (User) session.getAttribute("User");
        ObjectId userid = user.getId();
        List<Forum> forumList = forumRepo.findByuserId(userid);
        for (Forum forum: forumList
             ) {
            forum.setForum_user(user);
        }
        return forumList;
    }

}
