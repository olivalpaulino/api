package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projeto.api.model.Mensagem;

// Local para Validacao e Regras de Negocio

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Mensagem mensagem;
}
