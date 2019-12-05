package br.edu.unibratec.entregadeagua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Client;
import br.edu.unibratec.entregadeagua.model.Payment;

public class ClientDAO implements Operacoes<Client>{

	private List<Client> client = new ArrayList<Client>();
	private SessionFactory sessionFactory;
	
	public ClientDAO() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
				
	}
	

	public void insert(Client registro) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(registro);
		session.getTransaction().commit();
		session.close();
		
	}


	public void update(Client registro) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(registro);
		
		session.getTransaction().commit();
		session.close();
		
	}


	public void delete(int id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Client client = session.load(Client.class, id);
		session.delete(client);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<Client> listAll() {
		
		Session session = sessionFactory.openSession();
		
		List<Client> registros = session.createQuery("from Client").list();
		
		session.close();
		
		return registros;
	}
	
	public Client listById(int id) {
		Session session = sessionFactory.openSession();
		
		Client client = session.get(Client.class, id);
		
		session.close();
		
		return client;
	}

	public List<Client> listLastID() {

		Session session = sessionFactory.openSession();

		List<Client> registros = session.createQuery("from Client").list();

		session.close();

		return registros;
	}


	public Client getClientByCPF(String cpf) {


		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Client registro = (Client) session.createQuery("from Client where cpf = "+ cpf).uniqueResult();

		session.close();
		return registro;
	}
	

}
