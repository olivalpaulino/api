package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.projeto.api.repository.Repository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Pessoa;

@RestController
public class Controller {
	
	@Autowired
	private Repository acao;
	
	@PostMapping("/api")
	public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
		return acao.save(pessoa);
	}
	
	@GetMapping("/api")
	public List<Pessoa> selecionar() {
		return acao.findAll();
	}
	
	@GetMapping("/api/{codigo}")
	public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
		return acao.findByCodigo(codigo);
	}
	
	@PutMapping("/api")
	public Pessoa editar(@RequestBody Pessoa pessoa) {
		return acao.save(pessoa);
	}
	
	@DeleteMapping("/api/{codigo}")
	public void remover(@PathVariable int codigo) {
		Pessoa obj = selecionarPeloCodigo(codigo);
		
		acao.delete(obj);
	}
	
	@GetMapping("/api/contador")
	public Long contador() {
		return acao.count();
	}
	
	@GetMapping("api/ordenarnomes")
	public List<Pessoa> ordernarNomes() {
		return acao.findByOrderByNome();
	}
	
	@GetMapping("api/ordenarnomes2")
	public List<Pessoa> ordenarNomes2() {
		return acao.findByNomeOrderByIdadeDesc("Tatiana");
	}
	
	@GetMapping("api/nomecontem")
	public List<Pessoa> nomeContem() {
		return acao.findByNomeContaining("l");
	}
	
	@GetMapping("api/iniciacom")
	public List<Pessoa> iniciaCom() {
		return acao.findByNomeStartsWith("a");
	}
	
	@GetMapping("api/terminacom")
	public List<Pessoa> terminaCom(){
		return acao.findByNomeEndsWith("a");
	}
	
	@GetMapping("api/somaidades")
	public int somaIdades() {
		return acao.somaIdades();
	}

	@GetMapping("")
	public String mensagem() {
		return "Hello World!";
	}
	
	@GetMapping("/boasvindas")
	public String boasVindas() {
		return "Seja bem-vindo!";
	}
	
	@GetMapping("/boasvindas/{nome}")
	public String boasVindas(@PathVariable String nome) {
		return "Seja bem-vindo, "+nome;
	}
	
	@PostMapping("/pessoa")
	public Pessoa pessoa(@RequestBody Pessoa pessoa) {
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
		return pessoa;
	}
}
