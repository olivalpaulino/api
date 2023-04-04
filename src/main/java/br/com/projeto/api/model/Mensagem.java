package br.com.projeto.api.model;

import org.springframework.stereotype.Component;

// Apresenta uma resposta quando há algum erro de requisicao

@Component
public class Mensagem {

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
