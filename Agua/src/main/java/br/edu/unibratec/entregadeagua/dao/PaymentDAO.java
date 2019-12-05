package br.edu.unibratec.entregadeagua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.unibratec.entregadeagua.interfaces.Operacoes;
import br.edu.unibratec.entregadeagua.model.Payment;
import br.edu.unibratec.entregadeagua.model.Product;
import br.edu.unibratec.entregadeagua.model.Sale;

public class PaymentDAO implements Operacoes<Payment> {
	

	private List<Payment> payment = new ArrayList<Payment>();
	
	private SessionFactory sessionFactory;
	
	public PaymentDAO() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
				
	}
	
	
	public void insert(Payment registro) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(registro);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public void delete(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Payment payment = session.load(Payment.class, id);
		session.delete(payment);
		
		session.getTransaction().commit();
		session.close();
		
	}
	

	public void update(Payment payment) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(payment);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	public List<Payment> listAll() {
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Payment> registros = session.createQuery("from Payment").list();
		
		session.close();
		
		
		return registros;
	}

	
	public Payment listById(int id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Payment payment = session.get(Payment.class, id);
		
		session.getTransaction();
		session.close();
		
		return payment;
	}
	

	
}
