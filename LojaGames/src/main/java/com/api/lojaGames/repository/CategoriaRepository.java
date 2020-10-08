package com.api.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lojaGames.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	List<CategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
	List<CategoriaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
}
