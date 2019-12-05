package br.edu.unibratec.entregadeagua.controller;

import java.util.List;

import br.edu.unibratec.entregadeagua.dao.ClientDAO;
import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Client;

public class ClientController implements Operacoes<Client> {

	private ClientDAO dao;
	public ClientController() {
		dao = new ClientDAO();
	}
	
	
	public void insert(Client registro) {
		if (registro != null) {
			dao.insert(registro);
			//System.out.println("CLIENTE inserido com sucesso!");
			//System.out.println(registro.getIdClient() + "," +  registro.getNomeClient() + "," + registro.getAdress());
		}
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(Client registro) {
		dao.update(registro);
	}

	public List<Client> listAll() {
		return dao.listAll();
	}
	
	public List<Client> listLastId() {
		return dao.listLastID();
	}

	public Client listById(int id) {
		return dao.listById(id);
	}

	public Client listByCPF(String cPF) {	
		return dao.getClientByCPF(cPF);
	}


}
