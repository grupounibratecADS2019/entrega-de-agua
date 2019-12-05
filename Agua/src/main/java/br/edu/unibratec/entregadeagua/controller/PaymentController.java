package br.edu.unibratec.entregadeagua.controller;

import java.util.List;

import br.edu.unibratec.entregadeagua.dao.PaymentDAO;
import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Payment;

public class PaymentController implements Operacoes<Payment> {

	private PaymentDAO dao;
	public PaymentController() {
		dao = new PaymentDAO();
	}
	
	
	public void insert(Payment registro) {
		if (registro != null) {			
			dao.insert(registro);
			//System.out.println("TIPO DE PAGAMENTO inserido com sucesso!");
		}
		
	}

	public void delete(int id) {
		dao.delete(id);
		
	}

	public void update(Payment registro) {
		dao.update(registro);
		
	}

	public List<Payment> listAll() {
		return dao.listAll();
	}

	public Payment listById(int id) {
		return dao.listById(id);
	}

}
