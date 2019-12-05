package br.edu.unibratec.entregadeagua.controller;

import java.util.List;

import br.edu.unibratec.entregadeagua.model.Client;
import br.edu.unibratec.entregadeagua.model.Payment;
import br.edu.unibratec.entregadeagua.model.Product;
import br.edu.unibratec.entregadeagua.model.Sale;

public class OperacoesFacade {

	private static OperacoesFacade instancia;
	private static ClientController clientController;
	private static ProductController productController;
	private static PaymentController paymentController;
	private static SaleController saleController;

	private OperacoesFacade() {
	}

	public static OperacoesFacade getInstancia() {
		if (instancia == null) {
			instancia = new OperacoesFacade();
			clientController = new ClientController();
			productController = new ProductController();
			paymentController = new PaymentController();
			saleController = new SaleController();
		}

		return instancia;
	}

	public void insertClient(Client client) {

		clientController.insert(client);

	}

	public void deleteClient(int id) {

		Client exist;
		exist = clientController.listById(id);
		if (exist != null) {
			clientController.delete(id);
		}
	}

	public void updateClient(Client registro) {
		clientController.update(registro);
	}

	public List<Client> searchAllClient() {
		return clientController.listAll();
	}

	public List<Client> searchLastIdClient() {
		return clientController.listLastId();
	}

	public Client searchClientId(int id) {
		return clientController.listById(id);
	}

	public void insertProduct(Product product) {

		productController.insert(product);

	}

	public List<Product> searchAllProducts() {
		return productController.listAll();
	}
	
	public Product LystById(int id) {
		return productController.listById(id);
	}	
	
	public void insertPayment(Payment payment) {

		paymentController.insert(payment);

	}

	public List<Payment> searchAllPayment() {
		return paymentController.listAll();
	}

	public void insertSale(Sale sale) {

		//clientController.listByCPF(sale.getClient().getAdress());

		saleController.insert(sale);

	}

	public void cancelSale(Sale registro) {
		saleController.update(registro);
	}
	
	public void updateSale(Sale registro) {
		saleController.update(registro);
	}
		
	public List<Sale> searchAllSales() {
		return saleController.listAll();
	}
	
	public Sale searchIdSale(int id) {
		return saleController.listById(id);
	}
	
	public Client checkCPF(String cPF) {
		return this.checkCPF(cPF);
		
	}
}
