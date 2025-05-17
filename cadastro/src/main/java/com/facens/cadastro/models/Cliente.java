package com.facens.cadastro.models;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não ode ser nulo.")
    @Column(nullable = false, length = 80)
    @Size(max = 80, min = 3, message = "O tamanho deve ser entre 3 e 80.")
    private String nome;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email é inválido.")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "O CPF é obrigatório.")
    @CPF(message = "O CPF é inválido.")
    @Column(nullable = false, length = 11)
    private String cpf;

    @Past(message = "A data de nascimento deve ser anterior à de hoje.")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = true, length = 15)
    @Size(min=10, max=15, message = "O telefone deve conter de 10 à 15 digitos.")
    private String telefone;
}
