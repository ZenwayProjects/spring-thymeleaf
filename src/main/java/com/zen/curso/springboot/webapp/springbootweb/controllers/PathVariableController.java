package com.zen.curso.springboot.webapp.springbootweb.controllers;

import com.zen.curso.springboot.webapp.springbootweb.models.User;
import com.zen.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.saludo}")
    private String saludo;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String stringValues;

    @Value("${config.message}")
    private String[] message;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private String price;

    @Autowired
    Environment environment;


    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object>mix(@PathVariable String product, @PathVariable Long id){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;

    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/props")
    public Map<String, Object>prop(){
        Map<String, Object> json = new HashMap<>();
        Long code3 = environment.getProperty("config.code", Long.class);
        json.put("code", code);
        json.put("username", username);
        json.put("saludo", saludo);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("stringValues", stringValues);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        json.put("code2", Integer.valueOf(environment.getProperty("config.code")));
                                                                    json.put("code3",code3);
        return json;
    }
}
