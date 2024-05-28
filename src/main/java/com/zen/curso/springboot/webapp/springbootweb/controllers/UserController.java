package com.zen.curso.springboot.webapp.springbootweb.controllers;

import com.zen.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("David","Oliveros");

        model.addAttribute("title", "Hola mundo Springboot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User>usersModel(){
        return Arrays.asList(new User("Pepa", "Pig", "pepa@gmail.com"),
                new User("Lalo", "Cota"),
                new User("Pollo", "Pedro", "pollopedro@gmail.com"));
    }
}
