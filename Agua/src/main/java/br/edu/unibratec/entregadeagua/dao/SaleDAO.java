package br.edu.unibratec.entregadeagua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Payment;
import br.edu.unibratec.entregadeagua.model.Product;
import br.edu.unibratec.entregadeagua.model.Sale;

public class SaleDAO implements Operacoes<Sale> {

	
	 public static List<Sale> sale = new ArrayList<Sale>();
	
	private SessionFactory sessionFactory;
	
	public SaleDAO() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
				
	}
	
	public void insert(Sale registro) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(registro);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Sale sale = session.load(Sale.class, id);
		session.delete(sale);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void update(Sale sale) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(sale);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<Sale> listAll() {
		
		Session session = sessionFactory.openSession();

		List<Sale> registros = session.createQuery("from Sale").list();
		
		session.close();
		return registros;
	}

	public Sale listById(int id) {
		
		Session session = sessionFactory.openSession();

		Sale sale = session.get(Sale.class, id);
		
		session.close();
		return sale;
	}
	
	
	
}
