package com.facens.lombok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.facens.lombok.models.Pessoa;
import com.facens.lombok.repository.PessoaRepository;

@SpringBootApplication
public class LombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(LombokApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired PessoaRepository pessoaRepository) {
		return args -> {
			System.out.println("*** INSERINDO PESSOAS ***");
			Pessoa p1 = new Pessoa(null, "jhow", 10000.00);
			p1 = pessoaRepository.save(p1);
			Pessoa p2 = new Pessoa(null, "rafa", 10000.00);
			p2 = pessoaRepository.save(p2);
			Pessoa p3 = new Pessoa(null, "sa", 1500.00);
			p3 = pessoaRepository.save(p3);
			Pessoa p4 = new Pessoa(null, "lucas", 3000.00);
			p4 = pessoaRepository.save(p4);
			Pessoa p5 = new Pessoa(null, "baracca", 3000.00);
			p5 = pessoaRepository.save(p5);
			Pessoa p6 = new Pessoa(null, "mu",  5000.00);
			p6 = pessoaRepository.save(p6);

			List<Pessoa> resNome = pessoaRepository.findByNomeStartingWith("m");
			System.out.println("Nome começando com m:");
			for (Pessoa p : resNome){
				System.out.println(p.getNome());
			}
			
			
			List<Pessoa> resSalarioAlto = pessoaRepository.findBySalarioGreaterThan(3000.0);
			System.out.println("\nNome de quem tem salário maior que 3000:");
			for (Pessoa p : resSalarioAlto){
				System.out.println(p.getNome());
			}
			
			List<Pessoa> resPobres = pessoaRepository.findBySalarioLessThanEqual(3000);
			System.out.println("\nNome de quem tem salário menor que 3000:");
			for (Pessoa p : resPobres){
				System.out.println(p.getNome());
			}
		};
	}
}
