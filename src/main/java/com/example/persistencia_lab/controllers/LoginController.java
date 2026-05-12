package com.example.persistencia_lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    // Jamais faça isso
    @GetMapping("/login")
    public void login(HttpServletResponse response) {
        Cookie c = new Cookie("logado", "false");
        c.setPath("/");
        response.addCookie(c);
    }

    @GetMapping("/area-restrita")
    @ResponseBody
    public String area(HttpServletRequest request) {
        for (Cookie c : request.getCookies()) {
            if ("logado".equals(c.getName()) && "true".equals(c.getValue())) {
                return "Acesso liberado";
            }
        }
        return "Acesso negado";
    }

}
