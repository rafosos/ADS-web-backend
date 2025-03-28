package com.facens.lombok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.lombok.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    // Um método de consulta que retorne todos as pessoas com salário maior do que um determinado valor. Este
    // método deve receber um parâmetro do tipo Double chamado salário e retornar uma lista de pessoas com
    // salário maior do que o valor informado.
    List<Pessoa> findBySalarioGreaterThan(double salario);

    // Um método de consulta que retorne todos as pessoas com salário menor ou igual do que um determinado
    // valor. Este método deve receber um parâmetro do tipo Double chamado salário e retornar uma lista de
    // pessoas em que o salário seja menor ou igual ao valor informado.
    List<Pessoa> findBySalarioLessThanEqual(double salario);

    // Um método de consulta que retorne todos as pessoas que começam com um determinado nome. Este
    // método deve receber um parâmetro do tipo String chamado nome e retornar uma lista de pessoas em que o
    // nome começa com o nome informado
    List<Pessoa> findByNomeStartingWith(String nome);
}
