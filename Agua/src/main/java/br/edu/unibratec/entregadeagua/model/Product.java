package br.edu.unibratec.entregadeagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	@Column(nullable = false)
	private String descriptionProduct;

	public Product() {}
	
	public Product(String marca) {
		this.descriptionProduct = marca;
	}	
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}
	
}
