package com.api.lojaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.lojaGames.model.UsuarioModel;
import com.api.lojaGames.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	private ResponseEntity<List<UsuarioModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{idUsuario}")
	private ResponseEntity<UsuarioModel> getById(@PathVariable long idUsuario){
		return repository.findById(idUsuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nomeusuario/{nomeUsuario}")
	private ResponseEntity<List<UsuarioModel>> getByNomeUsuario(@PathVariable String nomeUsuario){
		return ResponseEntity.ok(repository.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario));
	}
	@GetMapping("emailusuario/{emailUsuario}")
	private ResponseEntity<List<UsuarioModel>> getByEmailUsuario(@PathVariable String emailUsuario){
		return ResponseEntity.ok(repository.findAllByEmailUsuarioContainingIgnoreCase(emailUsuario));
	}
	@PostMapping
	private ResponseEntity<UsuarioModel> postUsuario(@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	@PutMapping
	private ResponseEntity<UsuarioModel> putUsuario(@RequestBody UsuarioModel usuario){
		return ResponseEntity.ok(repository.save(usuario));
	}
	@DeleteMapping("{idUsuario}")
	private void deleteUsuario(@PathVariable long idUsuario) {
		repository.deleteById(idUsuario);
	}
}