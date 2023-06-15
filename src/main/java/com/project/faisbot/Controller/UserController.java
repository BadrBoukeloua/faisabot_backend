package com.project.faisbot.Controller;

import com.project.faisbot.Repository.UserRepo;
import com.project.faisbot.model.User;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userrepo ;

    @PostMapping("/Inscrire")
    public User newUser(@RequestBody User user){

        return userrepo.save(user);
    }
    @GetMapping("/users")
    public List<User> users (){

        return userrepo.findAll();
    }

    @PostMapping("/Profile")
    public User profile (@RequestBody @NotNull User newuser, @NotNull HttpSession session){
        User curuser = (User) session.getAttribute("User");
        newuser.setId(curuser.getId());
        return userrepo.save(newuser);
    }

}
