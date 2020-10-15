package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerGeral {
	//Injeção da Interface
	@Autowired
	private TemaRepository repository;
	
	//redireciona o localhost:8080/ para localhost:8080/index
	@GetMapping("/")
	public String index() {
		return "index";
	}

	//Um Get de outro jeito
	@RequestMapping(value="/cadastrarTema", method = RequestMethod.GET)
	public String form() {
		return "formTema";
	}
	
	//Um post table tema, redicionando para o endpoint cadastrarTema de volta
	@PostMapping(value="/cadastrarTema")
	public String form(Tema tema) {
		repository.save(tema);
		return "redirect:/cadastrarTema";
	}
}
