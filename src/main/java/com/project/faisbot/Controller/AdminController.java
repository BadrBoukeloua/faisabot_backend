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
public class AdminController {

    @Autowired
    private UserRepo userrepo ;

    @GetMapping("/Users")
    public List<User> users(HttpSession session){

        return userrepo.findAll();

    }

    @PostMapping("/AdminProfile")
    public User profile (@RequestBody @NotNull User newuser, @NotNull HttpSession session){
        User curuser = (User) session.getAttribute("Admin");
        newuser.setId(curuser.getId());
        return userrepo.save(newuser);
    }
}
