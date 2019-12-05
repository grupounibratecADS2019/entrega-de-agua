package br.edu.unibratec.entregadeagua.controller;

import java.util.List;

import br.edu.unibratec.entregadeagua.dao.SaleDAO;
import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Product;
import br.edu.unibratec.entregadeagua.model.Sale;

public class SaleController implements Operacoes<Sale> {

	private SaleDAO dao;
	public SaleController() {
		dao = new SaleDAO();
	}

	public void insert(Sale registro) {

		if (registro != null) {
			dao.insert(registro);
		}	
	}

	public void delete(int id) {
		dao.delete(id);

	}

	public void update(Sale registro) {
		dao.update(registro);

	}

	public List<Sale> listAll() {
		return dao.listAll();
	}

	public Sale listById(int id) {
		return dao.listById(id);
	}


}
