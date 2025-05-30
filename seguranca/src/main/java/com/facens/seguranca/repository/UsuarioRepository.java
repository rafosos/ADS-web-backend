package com.facens.seguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.seguranca.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByEmail(String email);
}
