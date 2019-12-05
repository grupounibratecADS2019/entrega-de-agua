package br.edu.unibratec.entregadeagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unibratec.entregadeagua.view.Menu;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idPayment;
	
	@Column(nullable = false)
	private String descriptionPayment;

	
	public Payment() {}
	
	public Payment(String tipoPagamento) {
		this.descriptionPayment = tipoPagamento;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public String getDescriptionPayment() {
		return descriptionPayment;
		
	}

	public void setDescriptionPayment(String descriptionPayment) {
		this.descriptionPayment = descriptionPayment;
	}
	
}
