package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.model.Mensagem;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repository;

// Local para Validacao e Regras de Negocio

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private Repository acao;
	
	// metodo cadastrar pessoa
	public ResponseEntity<?> cadastrar(Pessoa pessoa) {
		if (pessoa.getNome().equals("")) {
			mensagem.setMensagem("O campo nome precisa ser preenchido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if (pessoa.getIdade() < 0) {
			mensagem.setMensagem("Informe uma idade válida!");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(acao.save(pessoa), HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<?> cadastrar(Cliente cliente) {
		if (cliente.getNome().equals("")) {
			mensagem.setMensagem("O campo nome precisa ser preenchido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if (cliente.getEmail().equals("Informe um e-maill válido!")) {
			mensagem.setMensagem("Informe uma idade válida!");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(acao.save(cliente), HttpStatus.CREATED);
		}
	}
	
	// metodo selecionar
	public ResponseEntity<?> selecionar() {
		return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
	}
	
	// metodo selecionar pelo código (ID)
	public ResponseEntity<?> selecionarPeloCodigo(int codigo) {
		// nao tem cadastro
		if (acao.countByCodigo(codigo) == 0) {
			mensagem.setMensagem("Cadastro não encontrado!");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
		}
	}
	
	// metodo para editar dados
	public ResponseEntity<?> editar(Pessoa pessoa) {
		if (acao.countByCodigo(pessoa.getCodigo()) == 0) {
			mensagem.setMensagem("O código informado não existe!");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		} else if(pessoa.getNome().equals("")) {
			mensagem.setMensagem("É necessário informar um nome!");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if (pessoa.getIdade() < 0) {
			mensagem.setMensagem("Informe uma idade válida!");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(acao.save(pessoa), HttpStatus.OK);
		}
	}
	
	// metodo para remover cadastros
	public ResponseEntity<?> remover(int codigo) {
		// nao tem registro com esse codigo para excluir
		if (acao.countByCodigo(codigo) == 0) {
			mensagem.setMensagem("O código informado não existe!");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		} else {
			Pessoa pessoa = acao.findByCodigo(codigo);
			acao.delete(pessoa);
			mensagem.setMensagem("Pessoa Removida com Sucesso!");
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
	}
	
}
