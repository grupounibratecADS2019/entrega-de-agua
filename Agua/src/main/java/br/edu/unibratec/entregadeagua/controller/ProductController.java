package br.edu.unibratec.entregadeagua.controller;

import java.util.List;

import br.edu.unibratec.entregadeagua.dao.ProductDAO;
import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Product;

public class ProductController implements Operacoes<Product> {

	private ProductDAO dao;
	public ProductController() {
		dao = new ProductDAO();
	}
	
	
	public void insert(Product registro) {
		if(registro != null) {
			dao.insert(registro);
		}
	}

	public void delete(int id) {
		dao.delete(id);
		
	}

	public void update(Product registro) {
		dao.update(registro);
		
	}

	public List<Product> listAll() {
		return dao.listAll();
	}

	public Product listById(int id) {
		return dao.listById(id);
	}

	

}
