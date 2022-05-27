package br.com.senaibrasilia.projetofinal.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDao;
import br.com.senaibrasilia.projetofinal.dao.ProdutoDao;
import br.com.senaibrasilia.projetofinal.modelo.Categoria;
import br.com.senaibrasilia.projetofinal.modelo.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class Principal {

	public static void main(String[] args) {

		cadastrarProduto();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDao.buscarPorNome("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));

		List<Produto> precoDoProduto = produtoDao.buscarPorNome("Xiaomi Note 10 Pro");
		System.out.println("Preço do Produto: " + precoDoProduto);

	}

	private static void cadastrarProduto() {
		
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Note 10 Pro", "Tela amoled e bateria 5.000mAh",
				new BigDecimal("1850"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDAO = new ProdutoDao(em);
		CategoriaDao categoriaDAO = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}
}