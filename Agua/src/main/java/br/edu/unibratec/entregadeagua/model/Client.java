package br.edu.unibratec.entregadeagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unibratec.entregadeagua.controller.OperacoesFacade;
import br.edu.unibratec.entregadeagua.view.Menu;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	
	@Column(nullable = true)
	private String nomeClient;
	
	@Column(nullable = true)
	private String adress;
	
	@Column(nullable = true)
	private String tel;
	
	@Column(nullable = false , unique = true)
	private String CPF;
	
	public Client() {}	
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomeClient() {
		return nomeClient;
	}
	public void setNomeClient(String nomeClient) {
		this.nomeClient = nomeClient;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public void uniqueCPF(String cPF) {
		if(OperacoesFacade.getInstancia().checkCPF(cPF) != null) {System.out.println("CPF: "+cPF+" já cadastrado!!!");
		Menu.runAction(Menu.getOptionMenu());
		}
	}
}
