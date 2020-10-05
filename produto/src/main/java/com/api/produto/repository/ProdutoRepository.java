package com.api.produto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModel;

public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer>{

	//Listar todos os produtos
	List<ProdutoModel> findAll();
	
	// Pesquisar por código
	ProdutoModel findByCodigo(int codigo);
	
	//Remover Produto
	void delete(ProdutoModel produto)
;	
	//Cadastrar /Alterar Produto
	<ProdMod extends ProdutoModel> ProdMod save(ProdMod produto);
 }
