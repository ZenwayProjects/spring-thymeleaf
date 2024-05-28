package com.zen.curso.springboot.webapp.springbootweb.controllers;

import com.zen.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.zen.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Defecto") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto param = new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        }catch (NumberFormatException e){

        }
        ParamMixDto param = new ParamMixDto();
        param.setMessage(request.getParameter("message"));
        param.setCode(code);
        return param;
    }
}
