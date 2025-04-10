package com.facens.ac1supermercado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.facens.ac1supermercado.model.Cliente;
import com.facens.ac1supermercado.model.Produto;
import com.facens.ac1supermercado.model.Setor;
import com.facens.ac1supermercado.model.Venda;
import com.facens.ac1supermercado.repository.ClienteRepository;
import com.facens.ac1supermercado.repository.ProdutoRepository;
import com.facens.ac1supermercado.repository.VendaRepository;

@SpringBootApplication
public class Ac1supermercadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ac1supermercadoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(
	@Autowired ClienteRepository clienteRepository, 
	@Autowired VendaRepository vendaRepository, 
	@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			Cliente cliente1 = clienteRepository.save(new Cliente("11111111111", "15945785478", "José Antônio Souza e Cruz"));
			Cliente cliente2 = clienteRepository.save(new Cliente("22222222222", "15912345678", "joao pedro"));
			Cliente cliente3 = clienteRepository.save(new Cliente("33333333333", "65321548789", "felipe bueno"));
			Cliente cliente4 = clienteRepository.save(new Cliente("44444444444", "11458879532", "rafael augusto"));
			Cliente cliente5 = clienteRepository.save(new Cliente("55555555555", "14965874521", "lourenco ribeiro"));
			Cliente cliente6 = clienteRepository.save(new Cliente("66666666666", "2156487554", "joaquim barbosa"));
			Cliente cliente7 = clienteRepository.save(new Cliente("77777777777", "1548654875", "horacio  benicio"));
			Cliente cliente8 = clienteRepository.save(new Cliente("88888888888", "1522201325", "peter parker"));
			Cliente cliente9 = clienteRepository.save(new Cliente("99999999999", "15888888899", "mauricio de souza"));
			Cliente cliente10 = clienteRepository.save(new Cliente("00000000000", "11325689484", "chay suede"));

			Produto prod1 = produtoRepository.save(new Produto("leite", 6.50,Setor.Laticinios, LocalDate.now()));
			Produto prod2 = produtoRepository.save(new Produto("iogurte", 3.50,Setor.Laticinios, LocalDate.ofYearDay(2025, 164)));
			Produto prod3 = produtoRepository.save(new Produto("leite fermentado", 8.50,Setor.Laticinios, LocalDate.ofYearDay(2025, 10)));
			Produto prod4 = produtoRepository.save(new Produto("alcatra", 35.50,Setor.Laticinios, LocalDate.ofYearDay(2025, 1)));
			Produto prod5 = produtoRepository.save(new Produto("lenço umidecido", 10.00,Setor.Higiene, LocalDate.ofYearDay(2025, 264)));
			Produto prod6 = produtoRepository.save(new Produto("desinfetante", 6.00,Setor.Limpeza, LocalDate.ofYearDay(2025, 365)));
			Produto prod7 = produtoRepository.save(new Produto("rúcula", 3,Setor.Verduras, LocalDate.ofYearDay(2025, 49)));
			Produto prod8 = produtoRepository.save(new Produto("alface", 3,Setor.Verduras, LocalDate.ofYearDay(2025, 214)));
			Produto prod9 = produtoRepository.save(new Produto("maçã", 4,Setor.Frutas, LocalDate.ofYearDay(2025, 111)));
			Produto prod10 = produtoRepository.save(new Produto("banana", 2.99,Setor.Frutas, LocalDate.ofYearDay(2025, 13)));
			Produto prod11 = produtoRepository.save(new Produto("chia", 20,Setor.Graos, LocalDate.ofYearDay(2025, 74)));
			Produto prod12 = produtoRepository.save(new Produto("água de coco", 10.50,Setor.Bebidas, LocalDate.ofYearDay(2025, 98)));
			Produto prod13 = produtoRepository.save(new Produto("whey protein", 133.99,Setor.Suplementos, LocalDate.ofYearDay(2025, 46)));
			Produto prod14 = produtoRepository.save(new Produto("diamante negro", 8,Setor.Doces, LocalDate.ofYearDay(2025, 277)));
			Produto prod15 = produtoRepository.save(new Produto("chocolate batom", 2.99,Setor.Doces, LocalDate.ofYearDay(2025, 311)));

			vendaRepository.save(new Venda(prod1.getDescricao(), 2, prod1.getPreco(), cliente1, LocalDateTime.now()));
			vendaRepository.save(new Venda(prod2.getDescricao(), 3, prod2.getPreco(), cliente2, LocalDateTime.now()));
			vendaRepository.save(new Venda(prod3.getDescricao(), 1, prod3.getPreco(), cliente3, LocalDateTime.now()));
			vendaRepository.save(new Venda(prod4.getDescricao(), 4, prod4.getPreco(), cliente4, LocalDateTime.now()));
			vendaRepository.save(new Venda(prod5.getDescricao(), 12, prod5.getPreco(), cliente5, LocalDateTime.now()));
			vendaRepository.save(new Venda(prod6.getDescricao(), 4, prod6.getPreco(), cliente6, LocalDateTime.now()));
			vendaRepository.save(new Venda(prod7.getDescricao(), 9, prod7.getPreco(), cliente7, LocalDateTime.of(2025, 3, 29, 0, 0, 0)));
			vendaRepository.save(new Venda(prod8.getDescricao(), 1545485, prod8.getPreco(), cliente8, LocalDateTime.now()));

			// Buscar todos os produtos cujo preço seja maior que R$ 32,00.
			System.out.println("Buscar todos os produtos cujo preço seja maior que R$ 32,00.");
			produtoRepository.findByPrecoGreaterThan(32).forEach(System.out::println);
			
			// Buscar todos os produtos do setor de laticínios.
			System.out.println("Buscar todos os produtos cujo preço seja maior que R$ 32,00.");
			produtoRepository.findBySetorIs(Setor.Laticinios).forEach(System.out::println);
			
			// Buscar todos os produtos que vencem depois de 18/04.
			System.out.println(" Buscar todos os produtos que vencem depois de 18/04.");
			produtoRepository.findByValidadeAfter(LocalDate.of(2025, 4, 18)).forEach(System.out::println);
			
			// Buscar um cliente pelo CPF
			System.out.println(" Buscar um cliente pelo CPF");
			System.out.println(clienteRepository.findByCpfIs(cliente1.getCpf()));
			
			// Buscar um cliente pelo número de celular.
			System.out.println(" Buscar um cliente pelo número de celular.");
			System.out.println(clienteRepository.findByCelularIs(cliente3.getCelular()));
			
			// Buscar todas as vendas do cliente: José Antônio Souza e Cruz.
			System.out.println(" Buscar todas as vendas do cliente: José Antônio Souza e Cruz.");
			vendaRepository.findByNomeCliente("José Antônio Souza e Cruz").forEach(System.out::println);
			
			// Buscar todas as vendas cujo valor total seja maior que R$ 1528,32.
			System.out.println("// Buscar todas as vendas cujo valor total seja maior que R$ 1528,32.");
			vendaRepository.findByValorTotalGreaterThan(1528.32).forEach(System.out::println);

			// Buscar todas as vendas realizadas entre 01/01/2025 a 31/03/2025.
			System.out.println("// Buscar todas as vendas realizadas entre 01/01/2025 a 31/03/2025.");
			vendaRepository.findByDataVendaBetween(LocalDateTime.of(2025, 1, 1, 0, 0, 0), LocalDateTime.of(2025, 3, 31, 0, 0, 0)).forEach(System.out::println);

			// Buscar todas as vendas do produtoId igual a 2385.
			System.out.println("// Buscar todas as vendas do produtoId igual a 2385");
			vendaRepository.findAllById(Arrays.asList(2385L)).forEach(System.out::println);
		};	
	}
}
