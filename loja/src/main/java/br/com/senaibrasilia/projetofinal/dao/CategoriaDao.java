package br.com.senaibrasilia.projetofinal.dao;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao() {

	}

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	// Cadastrar categoria (PERSIST)
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

	// Atualizar informações do primeiro Cadastro (MERGE)
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}

	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);

	}

}
