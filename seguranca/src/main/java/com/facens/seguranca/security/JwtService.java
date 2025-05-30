package com.facens.seguranca.security;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.facens.seguranca.SegurancaApplication;
import com.facens.seguranca.models.Usuario;
import com.facens.seguranca.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    @Value("525600")
    private String expiracao;

    @Value("saopaulo")
    private String chaveAssinatura;

    public static void main(String[] args){
        ConfigurableApplicationContext contexto = SpringApplication.run(SegurancaApplication.class);
        JwtService service = contexto.getBean(JwtService.class);
        UsuarioRepository usuarioRepository = contexto.getBean(UsuarioRepository.class);
        PasswordEncoder passwordEncoder = contexto.getBean(PasswordEncoder.class);
        Usuario usuario = new Usuario(0, "Rafael", "rafa@facens.br", passwordEncoder.encode("123"), "Administrador");
        String token = service.gerarToken(usuario);
        System.out.println(token);
        boolean isValid = service.validarToken(token);
        System.out.println("Token válido? " + isValid);
        System.out.println("Usuário: " + service.obterLoginUsuario(token));
        
        Usuario usuario2 = new Usuario(0, "jhow", "jhow@facens.br", passwordEncoder.encode("1234"), "");

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);
    }


    public String gerarToken(Usuario usuario){
        long exp = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(exp);
        Date date = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", usuario.getId());
        claims.put("email", usuario.getEmail());
        claims.put("perfil", usuario.getPerfil());
        return Jwts.builder()
            .setClaims(claims)
            .setExpiration(date)
            .signWith(getSignKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public Claims obterClaims(String token) throws ExpiredJwtException{
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private Key getSignKey(){
        byte[] key = Decoders.BASE64.decode(chaveAssinatura);
        return Keys.hmacShaKeyFor(key);
    }

    public boolean validarToken(String token){
        try {
            Claims claims = obterClaims(token);
            Date dataExpiracao = claims.getExpiration();
            LocalDateTime data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }

    public String obterLoginUsuario(String token) throws ExpiredJwtException{
        Claims c = obterClaims(token);
        return (String) c.get("email");
    }

}
