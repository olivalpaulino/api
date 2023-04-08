package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.model.Pessoa;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Pessoa, Integer>{
	List<Pessoa> findAll();
	
	Pessoa findByCodigo(int codigo);
	
	List<Pessoa> findByOrderByNome(); // findByOrderByNomeAsc() -- ordenar letras de a a z, 0 a ...
	// ordenar do maior valor ao menor findByOrderByNomeDesc() ou do maior numero ao menor
	
	List<Pessoa> findByNomeOrderByIdadeDesc(String nome);
	
	List<Pessoa> findByNomeContaining(String termo);
	
	List<Pessoa> findByNomeStartsWith(String termo);
	
	List<Pessoa> findByNomeEndsWith(String termo);
	
	@Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
	int somaIdades();
	
	@Query(value = "SELECT * from pessoas WHERE idade >= :idade", nativeQuery = true)
	List<Pessoa> idadeMaiorIgual(int idade);
	
	int countByCodigo(int codigo); // ajuda a verificar se tem ou nao cadastro
	
	Cliente save(Cliente cliente);
}
