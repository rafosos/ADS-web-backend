package com.facens.seguranca.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paginas")
public class PaginasController {

    @GetMapping("/")
    public String getBemVindo(){
        return "Bem vindo";
    }

    @GetMapping("/admin")
    @Secured("ADMIN")
    public String getDeAdmin(){
        return "Área de Administração";
    }

    @GetMapping("/user")
    @Secured("USER")
    public String getDeUsuario(){
        return "Área de usuários";
    }

}
