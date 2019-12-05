package br.edu.unibratec.entregadeagua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Payment;
import br.edu.unibratec.entregadeagua.model.Product;
import br.edu.unibratec.entregadeagua.model.Sale;

public class ProductDAO implements Operacoes<Product> {

	public List<Product> product = new ArrayList<Product>();
	
	private SessionFactory sessionFactory;
	
	public ProductDAO() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
				
	}
	
	public void insert(Product registro) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(registro);
		session.getTransaction().commit();
		session.close();
		
		
	}

	public void delete(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Product product = session.load(Product.class, id);
		session.delete(product);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void update(Product product) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(product);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	public List<Product> listAll() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Product> registros = session.createQuery("from Product").list();
		
		session.close();
		
		
		return registros;
	}

	public Product listById(int id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		
		session.getTransaction();
		session.close();
		
		return product;
	}
	
}
