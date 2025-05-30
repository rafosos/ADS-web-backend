package com.facens.seguranca.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.facens.seguranca.dtos.UsuarioDTO;
import com.facens.seguranca.models.Usuario;

public interface IUsuarioService {
    Usuario salvar(UsuarioDTO dto);
    UsuarioDTO getById(int id);
    List<UsuarioDTO> getAll();
    UserDetails autenticar(Usuario usuario);
}
