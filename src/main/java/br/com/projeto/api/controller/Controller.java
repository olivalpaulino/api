package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.projeto.api.repository.Repository;
import br.com.projeto.api.service.Service;

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
	
	@Autowired
	private Service servico;
	
	@PostMapping("/api")
	public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa) {
		return servico.cadastrar(pessoa);
	}
	
	@GetMapping("/api")
	public ResponseEntity<?> selecionar() {
		return servico.selecionar();
	}
	
	@GetMapping("/api/{codigo}")
	public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) {
		return servico.selecionarPeloCodigo(codigo);
	}
	
	@PutMapping("/api")
	public ResponseEntity<?> editar(@RequestBody Pessoa pessoa) {
		return servico.editar(pessoa);
	}
	
	@DeleteMapping("/api/{codigo}")
	public ResponseEntity<?> remover(@PathVariable int codigo) {
		return servico.remover(codigo);
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
	
	@GetMapping("api/idademaiorigual")
	public List<Pessoa> idadeMaiorIgual() {
		return acao.idadeMaiorIgual(18);
	}
	
	@GetMapping("/status")
	public ResponseEntity<?> status() {
		return new ResponseEntity<>(HttpStatus.CREATED);
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
