package com.facens.seguranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.facens.seguranca.dtos.AutenticacaoDTO;
import com.facens.seguranca.dtos.TokenDTO;
import com.facens.seguranca.models.Usuario;
import com.facens.seguranca.security.JwtService;
import com.facens.seguranca.services.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @PostMapping()
    public TokenDTO autenticar(@RequestBody AutenticacaoDTO autenticacao){
        try {
            Usuario usuario = new Usuario(0, "", autenticacao.getEmail(), autenticacao.getSenha(), "");
            usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getEmail(), token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}
