package com.api.lojaGames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.lojaGames.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	List<UsuarioModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
	List<UsuarioModel> findAllByEmailUsuarioContainingIgnoreCase(String emailUsuario);
}
