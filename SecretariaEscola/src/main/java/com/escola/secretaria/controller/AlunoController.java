package com.escola.secretaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.escola.secretaria.model.AlunoModel;
import com.escola.secretaria.repository.AlunoRepository;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/alunos")
	public List<AlunoModel> findAllAluno() {
		return repository.findAll();
	}
	@GetMapping("/alunos/{id}")
	public ResponseEntity<AlunoModel> GetbyId(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	@PostMapping("/alunos")
	public AlunoModel postAluno(@RequestBody AlunoModel aluno) {
		repository.save(aluno);
		return aluno;
	}
	@PutMapping("/alunos/{id}")
	public AlunoModel putAluno(@PathVariable Long id, @RequestBody AlunoModel aluno) {
		aluno.setId(id);
		repository.save(aluno);
		return aluno;
	}
	@DeleteMapping("alunos/{id}")
	public String deleteAluno(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado com sucesso";
	}
}