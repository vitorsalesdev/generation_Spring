package com.geral.demo;

import javax.persistence.*;

@Entity
@Table
public class tb_conexao {
	
	@Id
	private Integer id;
	@Column
	private String nome;
	
	//Getters e setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}