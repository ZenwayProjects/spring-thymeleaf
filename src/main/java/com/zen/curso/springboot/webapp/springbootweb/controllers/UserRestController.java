package com.zen.curso.springboot.webapp.springbootweb.controllers;

import com.zen.curso.springboot.webapp.springbootweb.models.User;
import com.zen.curso.springboot.webapp.springbootweb.models.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("David","Oliveros");
        userDto.setUser(user);
        userDto.setTitle("Hola Springboot");
        return userDto;

    }

    @GetMapping("/list")
    public List<User>list(){
        User user1 = new User("Angel", "Oliveros");
        User user2 = new User("Zenway", "Right");
        User user3 = new User("John", "Doe");

        List<User> users = Arrays.asList(user1,user2, user3);
        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){
        User user = new User("David","Oliveros");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola mundo Springboot");
        body.put("user",user );
        return body;
    }
}
