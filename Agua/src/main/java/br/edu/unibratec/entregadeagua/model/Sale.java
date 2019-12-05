package br.edu.unibratec.entregadeagua.model;


import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sale {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int idSale;
    
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Product product;
        
    @ManyToOne
    private Payment payment;
    
    private Instant horario;
    private String status;
	
    public Sale() {}
    
	public Sale(int idSale, Client client, Product product, Payment payment, Instant horario, String status) {
		super();
		this.idSale = idSale;
		this.client = client;
		this.product = product;
		this.payment = payment;
		this.horario = horario;
		this.status = status;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getHorario() {
		return horario;
	}

	public void setHorario(Instant horario) {
		this.horario = horario;
	}

	
    
}
