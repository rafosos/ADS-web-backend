package com.facens.seguranca.services;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.facens.seguranca.dtos.UsuarioDTO;
import com.facens.seguranca.exceptions.RegraNegocioException;
import com.facens.seguranca.models.Usuario;
import com.facens.seguranca.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService, UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO dto){
        Usuario user = new Usuario();
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());
        user.setPerfil(dto.getPerfil());

        return usuarioRepository.save(user);
    }

    @Override
    public UsuarioDTO getById(int id){
        return usuarioRepository.findById(id).map(u -> {
            return UsuarioDTO
                .builder()
                .email(u.getEmail())
                .perfil(u.getPerfil())
                .build();
        }).orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
    }

    @Override
    public List<UsuarioDTO> getAll(){
        List<UsuarioDTO> dados = usuarioRepository.findAll().stream().map(u -> {
            return UsuarioDTO.builder()
                .email(u.getEmail())
                .perfil(u.getPerfil())
                .build();
        }).toList();
        return dados;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        String[] roles = usuario.getPerfil() == "Administrador" ? new String[]{"ADMIN", "USER"} : new String[]{"USER"};
        return User.builder()
            .username(usuario.getEmail())
            .password(usuario.getSenha())
            .roles(roles)
            .build();
    }

    @Override
    public UserDetails autenticar(Usuario usuario){
        UserDetails user = loadUserByUsername(usuario.getEmail());
        boolean senhaOK = passwordEncoder.matches(usuario.getSenha(), user.getPassword());
        System.out.println(user.getPassword());
        System.out.println(usuario.getSenha());
        if (senhaOK){
            return user;
        }
        throw new RegraNegocioException("Senha inválida");
    }
}
