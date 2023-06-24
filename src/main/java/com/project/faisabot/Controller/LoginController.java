package com.project.faisabot.Controller;

import com.project.faisabot.Repository.UserRepo;
import com.project.faisabot.model.Loginfo;
import com.project.faisabot.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin

public class LoginController {

    @Autowired
    private UserRepo userrepo;


    @PostMapping("/Inscrire")
    public User newUser(@RequestBody User user){

        return userrepo.save(user);
    }
    @PostMapping ("/Connecter")
    public User Login(@RequestBody Loginfo info, HttpSession session){

        String email = info.getEmail();
        String password = info.getPassword();
        if (session.getAttribute("Admin") == null || session.getAttribute("User") == null ) {
            User authuser = userrepo.findByEmailAndPassword(email, password);
            if (authuser != null) {
                if (authuser.isAdmin() == true) {
                    session.setAttribute("Admin", authuser);

                    System.out.println(session.getAttribute("Admin"));

                } else {
                    session.setAttribute("User", authuser);

                    System.out.println(session.getAttribute("User"));
                }
            }
            return authuser;
        }
        return  null ;
    }

    @GetMapping("/Deconnecter")
    public String Logout (HttpSession session){

        if(session.getAttribute("Admin") != null) {
            session.removeAttribute("Admin");

        }
        if(session.getAttribute("User") != null) {
            session.removeAttribute("User");
        }

        session.invalidate();

        return "Disconnected";
    }

    @GetMapping("/ses")
    public User ses(HttpSession session){

        if(session.getAttribute("Admin") != null) {
         return (User) session.getAttribute("Admin");
        }
        if(session.getAttribute("User") != null) {
           return (User) session.getAttribute("User");
        }
        return null;
    }
}
