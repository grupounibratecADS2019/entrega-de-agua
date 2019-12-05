package br.edu.unibratec.entregadeagua.view;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import br.edu.unibratec.entregadeagua.controller.OperacoesFacade;
import br.edu.unibratec.entregadeagua.model.Client;
import br.edu.unibratec.entregadeagua.model.Payment;
import br.edu.unibratec.entregadeagua.model.Product;
import br.edu.unibratec.entregadeagua.model.Sale;
import br.edu.unibratec.entregadeagua.util.VendaValidator;

public class Menu {

	static OperacoesFacade facade = OperacoesFacade.getInstancia();
	static Scanner teclado = new Scanner(System.in);


	private void setup() {

		Product product1 = new Product();
		product1.setDescriptionProduct("Santa Clara");
		facade.insertProduct(product1);

		Product product2 = new Product();
		product2.setDescriptionProduct("Indaiá");
		facade.insertProduct(product2);

		Product product3 = new Product();
		product3.setDescriptionProduct("Santa Joana");
		facade.insertProduct(product3);

		Payment payment1 = new Payment();
		payment1.setDescriptionPayment("Dinheiro");
		facade.insertPayment(payment1);

		Payment payment2 = new Payment();
		payment2.setDescriptionPayment("Cartão");
		facade.insertPayment(payment2);

		Client client1 = new Client();
		client1.setNomeClient("Rayza Wilma");
		client1.setAdress("Av Boa viagem 123");
		client1.setTel("(81)3333-3333");
		client1.setCPF("70609433075");
		facade.insertClient(client1);

		Client client2 = new Client();
		client2.setNomeClient("Thalita Brayner");
		client2.setAdress("Rua Nova 456");
		client2.setTel("(81)98888-8888");
		client2.setCPF("24093761000");
		facade.insertClient(client2);

		Client client3 = new Client();
		client3.setNomeClient("Rafael Teste");
		client3.setAdress("Travessa 890");
		client3.setTel("(81)99999-8888");
		client3.setCPF("48235674041");
		facade.insertClient(client3);

		Sale sale1 = new Sale();
		Instant horario1 = Instant.now();

		sale1.setClient(client1);
		sale1.setProduct(product1);
		sale1.setPayment(payment1);
		sale1.setHorario(horario1);
		sale1.setStatus("Ativo");
		facade.insertSale(sale1);

		Sale sale2 = new Sale();
		Instant horario2 = Instant.now();

		sale2.setClient(client2);
		sale2.setProduct(product1);
		sale2.setPayment(payment2);
		sale2.setHorario(horario2);
		sale2.setStatus("Ativo");
		facade.insertSale(sale2);

		Sale sale3 = new Sale();
		Instant horario3 = Instant.now();

		sale3.setClient(client3);
		sale3.setProduct(product3);
		sale3.setPayment(payment1);
		sale3.setHorario(horario3);
		sale3.setStatus("Ativo");
		facade.insertSale(sale3);
	}

	public void headSystem() {

		System.out.println();
		System.out.println("======== EQUIPE =========");
		System.out.println("|   Raphael Burkhardt   |");         
		System.out.println("|    Thalita Brayner    |");  
		System.out.println("|      Rayza Wilma      |");   
		System.out.println("|     Valério Pinto     |"); 
		System.out.println("=========================");
		System.out.println();

		if (facade.searchAllClient().size() == 0) {
			setup();
		}
	}
	//OK

	public static String getOptionMenu() {

		System.out.println("======== MENU ========");
		System.out.println("1 - Realizar Venda   |");
		System.out.println("2 - Cancelar Venda   |");
		System.out.println("3 - Editar   Venda   |");
		System.out.println("4 - Lista de Vendas  |");
		System.out.println("5 - Sair do Sistema  |");
		System.out.println("======================");
		String opcao = teclado.next();

		return opcao;
	}
	//OK

	public static void runAction(String option) {
		switch (option) {
		case "1":
			realizarVenda();
			break;
		case "2":
			cancelarVenda();
			break;
		case "3":
			editarVenda();
			break;
		case "4":
			exibirTipoLista();
			break;
		case "5":
			sairDoSistema();
			break;
		default:
			System.out.println("Opção inválida! ");
			String opcao = getOptionMenu();
			runAction(opcao);
			break;
		}
	}
	//OK	

	private static void realizarVenda() {

		Sale sale = new Sale();
		Product produto = new Product();
		Client cliente = new Client();
		Payment pagamento = new Payment();

		System.out.print("Digite o nome do cliente: ");
		String nome = teclado.next();
		String sobrenome=teclado.nextLine();
		String nomeCompleto = nome+""+sobrenome;
		VendaValidator.validName(nomeCompleto);


		System.out.print("Digite o CPF: ");
		String CPF = teclado.next();
		VendaValidator.validCPF(CPF);	
		teclado.nextLine();

		System.out.print("Digite o endereço: ");
		String end1 = teclado.next();
		String end2=teclado.nextLine();
		String endereco = end1+""+end2;
		VendaValidator.validEndereco(endereco);

		System.out.print("Digite o telefone: ");
		String tel = teclado.next();
		VendaValidator.validTel(tel);	
		teclado.nextLine();

		System.out.println();
		System.out.println("Escolha a marca da Água:");
		String product = getProduct();

		System.out.println("Digite a forma de pagamento: ");
		String formaPagamento = exibirFormaPagamento();

		String status = "Ativo";
		Instant horario = Instant.now();

		cliente.setNomeClient(nomeCompleto);
		cliente.setCPF(CPF);
		cliente.setAdress(endereco);
		cliente.setTel(tel);
		produto.setDescriptionProduct(product);
		pagamento.setDescriptionPayment(formaPagamento);

		sale.setClient(cliente);
		sale.setProduct(produto);
		sale.setPayment(pagamento);
		sale.setStatus(status);
		sale.setHorario(horario);

		facade.insertClient(cliente);
		facade.insertProduct(produto);
		facade.insertPayment(pagamento);
		facade.insertSale(sale);
		System.out.println("Cadastrado com sucesso!!!\n");
		String choice = getOptionMenu();
		runAction(choice);

	}
	//OK

	private static String getProduct() {

		System.out.println("===== Opções de Marcas =====");
		System.out.println("|      1 - Indaiá          |");
		System.out.println("|      2 - Santa Joana     |");
		System.out.println("|      3 - Santa Clara     |");
		System.out.println("============================");

		String opcao = teclado.next();

		switch (opcao) {
		case "1":
			opcao = "Indaiá";
			break;
		case "2":
			opcao = "Santa Joana";
			break;
		case "3":
			opcao = "Santa Clara";
			break;
		default:
			System.out.println("opção inválida! ");
			getProduct();
			break;
		}

		return opcao;
	}

	//OK
	private static String exibirFormaPagamento() {

		System.out.println("==== Opções de Pagamento =====");
		System.out.println("|        1 - Dinheiro        |");
		System.out.println("|        2 - Cartão          |");
		System.out.println("==============================");

		String opcao = teclado.next();

		switch (opcao) {
		case "1":
			opcao = "Dinheiro";
			break;
		case "2":
			opcao = "Cartão";
			break;

		default:
			System.out.println("Opção inválida! ");
			exibirFormaPagamento();
			break;
		}

		return opcao;

	}
	//OK

	private static void exibirTipoLista() {

		System.out.println("=== Como Deseja Listar os Dados ? ===");
		System.out.println("|       1 - Todas as vendas         |");
		System.out.println("|       2 - Por tipo de pagamento   |");
		System.out.println("|       3 - Pela marca da água      |");
		System.out.println("=====================================");

		String opcao = teclado.next();

		switch (opcao) {
		case "1":
			listarVendasTotal();
			break;
		case "2":
			listarPorPagamento();
			break;
		case "3":
			listarPorMarcaDeAgua();
			break;

		default:
			System.out.println("opção inválida! ");
			exibirFormaPagamento();
			break;
		}
	}

	private static void cancelarVenda() {

		int returnId=0;
		Instant hourCancel = Instant.now();
		List<Sale> allSales = facade.searchAllSales();

		for (Sale registro : allSales) {
			System.out.println("========================");
			System.out.println("ID: " + registro.getIdSale());
			System.out.println("Nome: " + registro.getClient().getNomeClient());
		}System.out.println("========================");
		System.out.println("Qual ID deseja Cancelar?");

		try {
			returnId = Integer.parseInt(teclado.next());
		} catch (NumberFormatException e) { System.out.println("ID inválido!");
		String opcao = getOptionMenu();
		runAction(opcao);}

		//checar se realmente está contando o tempo certo
		Sale sale = facade.searchIdSale(returnId);
		Instant horaVenda = sale.getHorario();
		Duration duracao = Duration.between(horaVenda, hourCancel);
		long duracaoEmMinutos = duracao.toMinutes();

		if (duracaoEmMinutos >= 1) {
			System.out.println("Não é possível cancelar venda! TEMPO EXCEDIDO!");
			String opcao = getOptionMenu();
			runAction(opcao);
		} else {
			sale.setStatus("Cancelada");
			facade.cancelSale(sale);

			System.out.println("Venda " + sale.getIdSale() + " cancelada com sucesso!!!\n");

			String opcao = getOptionMenu();
			runAction(opcao);
		}
	}
	//OK

	private static String getEditOption() {

		System.out.println("======= EDITAR =======");
		System.out.println("1 - Telefone         |");
		System.out.println("2 - Endereço         |");
		System.out.println("3 - Marca            |");
		System.out.println("4 - Pagamento        |");
		System.out.println("======================");
		String opcao = teclado.next();

		return opcao;
	}

	private static void editarVenda() {	
		int returnId=0;
		Instant hourCancel = Instant.now();
		List<Sale> allSales = facade.searchAllSales();

		for (Sale registro : allSales) {
			System.out.println("========================");
			System.out.println("ID: " + registro.getIdSale());
			System.out.println("Nome: " + registro.getClient().getNomeClient());
		}System.out.println("========================");

		System.out.println("Qual ID deseja editar?");
		try {
			returnId = Integer.parseInt(teclado.next());
		} catch (NumberFormatException e) { System.out.println("ID inválido!");
		String opcao = getOptionMenu();
		runAction(opcao);
		}
		Sale sale = facade.searchIdSale(returnId);
		Instant horaVenda = sale.getHorario();
		Duration duracao = Duration.between(horaVenda, hourCancel);
		long duracaoEmMinutos = duracao.toMinutes();

		if (duracaoEmMinutos >= 1) {
			System.out.println("Não é possível editar venda! TEMPO EXCEDIDO!");
			String opcao = getOptionMenu();
			runAction(opcao);
		} 
		
		System.out.println(
				"ID: " + sale.getIdSale() + "\n" + 
						"NOME: "     + sale.getClient().getNomeClient() + "\n" + 
						"CPF: "      + sale.getClient().getCPF() + "\n" + 
						"Endereço: " + sale.getClient().getAdress() + "\n" + 
						"Telefone: " + sale.getClient().getTel() + "\n" + 
						"Marca: "    + sale.getProduct().getDescriptionProduct() + "\n" + 
						"Pagamento: "+ sale.getPayment().getDescriptionPayment() + "\n" + 
						"Status: "   + sale.getStatus());
		System.out.println("");
		String option = getEditOption();
		switch (option) {
		case "1":
			System.out.println("Digite o telefone desejado: ");
			String tel = teclado.next();
			VendaValidator.validTel(tel);
			sale.getClient().setTel(tel);
			facade.updateClient(sale.getClient());
			System.out.println("Telefone editado com sucesso!!!");
			break;
		case "2":
			System.out.println("Digite o endereço desejado: ");
			String end1 = teclado.next();
			String end2=teclado.nextLine();
			String endereco = end1+""+end2;
			VendaValidator.validEndereco(endereco);
			sale.getClient().setAdress(endereco);
			facade.updateClient(sale.getClient());
			System.out.println("Endereço editado com sucesso!!!");
			break;
		case "3":
			String marca = getProduct();						
			if (marca.equalsIgnoreCase("Indaiá")) {
				sale.getProduct().setIdProduct(2);
				facade.updateSale(sale);
			} else if (marca.equalsIgnoreCase("Santa Joana")) {
				sale.getProduct().setIdProduct(3);
				facade.updateSale(sale);
			} else {
				sale.getProduct().setIdProduct(1);
				facade.updateSale(sale);
			}			
			System.out.println("Marca editada com sucesso!!!");
			break;
		case "4":
			String pagamento = exibirFormaPagamento();
			if (pagamento.equalsIgnoreCase("Dinheiro")) {
				sale.getPayment().setIdPayment(1);
				facade.updateSale(sale);
			}else {
				sale.getPayment().setIdPayment(2);
				facade.updateSale(sale);
			}
			System.out.println("Pagamento editado com sucesso!!!");
			break;
		default:
			System.out.println("Opção inválida! ");
			break;			
		}
		String opcao = getOptionMenu();
		runAction(opcao);
	}
	//OK

	private static void listarVendasTotal() {

		List<Sale> allSales = facade.searchAllSales();
		if (facade.searchAllClient().size() == 0) {System.out.println("Lista de vendas vazia!!\n");
		String choice = getOptionMenu();
		runAction(choice);}

		for (Sale registro : allSales) {
			System.out.println(
					"ID: " + registro.getIdSale() + "\n" + 
							"NOME: " + registro.getClient().getNomeClient() + "\n" + 
							"CPF: " + registro.getClient().getCPF() + "\n" + 
							"Endereço: "+ registro.getClient().getAdress() + "\n" + 
							"Telefone: "+ registro.getClient().getTel() + "\n" + 
							"Marca: "+ registro.getProduct().getDescriptionProduct() + "\n" + 
							"Pagamento: "+ registro.getPayment().getDescriptionPayment() + "\n" + 
							"Status: "+ registro.getStatus());
			System.out.println("");

		}
		String choice = getOptionMenu();
		runAction(choice);
	}
	//OK	

	private static void listarPorPagamento() {

		String formapagamento = exibirFormaPagamento();

		if (formapagamento == "Dinheiro") {

			List<Sale> allSales = facade.searchAllSales();
			if (facade.searchAllClient().size() == 0) {System.out.println("Lista de vendas vazia!!\n");
			String choice = getOptionMenu();
			runAction(choice);}
			for (Sale registro : allSales) {
				if (registro.getPayment().getDescriptionPayment().equals(formapagamento)) {
					System.out.println(
							"ID: " + registro.getIdSale() + "\n" + 
									"NOME: " + registro.getClient().getNomeClient() + "\n" + 
									"CPF: " + registro.getClient().getCPF() + "\n" + 
									"Endereço: "+ registro.getClient().getAdress() + "\n" + 
									"Telefone: "+ registro.getClient().getTel() + "\n" + 
									"Marca: "+ registro.getProduct().getDescriptionProduct() + "\n" + 
									"Pagamento: "+ registro.getPayment().getDescriptionPayment() + "\n" + 
									"Status: "+ registro.getStatus());
					System.out.println("");
				}
			}
			String choice = getOptionMenu();
			runAction(choice);
		} else {

			formapagamento = "Cartão";

			List<Sale> allSales = facade.searchAllSales();
			
			for (Sale registro : allSales) {
				if (registro.getPayment().getDescriptionPayment().equals(formapagamento)) {
					System.out.println(
							"ID: " + registro.getIdSale() + "\n" + 
									"NOME: " + registro.getClient().getNomeClient() + "\n" + 
									"CPF: " + registro.getClient().getCPF() + "\n" + 
									"Endereço: "+ registro.getClient().getAdress() + "\n" + 
									"Telefone: "+ registro.getClient().getTel() + "\n" + 
									"Marca: "+ registro.getProduct().getDescriptionProduct() + "\n" + 
									"Pagamento: "+ registro.getPayment().getDescriptionPayment() + "\n" + 
									"Status: "+ registro.getStatus());
					System.out.println("");
				}
			}
			String choice = getOptionMenu();
			runAction(choice);
		}

	}

	private static void listarPorMarcaDeAgua() {

		String marca=getProduct();

		if (marca.equalsIgnoreCase("Indaiá")) {
			List<Sale> allSales = facade.searchAllSales();

			for (Sale registro : allSales) {

				if (registro.getProduct().getDescriptionProduct().equalsIgnoreCase(marca)) {
					System.out.println(
							"ID: " + registro.getIdSale() + "\n" + 
									"NOME: " + registro.getClient().getNomeClient() + "\n" + 
									"CPF: " + registro.getClient().getCPF() + "\n" + 
									"Endereço: "+ registro.getClient().getAdress() + "\n" + 
									"Telefone: "+ registro.getClient().getTel() + "\n" + 
									"Marca: "+ registro.getProduct().getDescriptionProduct() + "\n" + 
									"Pagamento: "+ registro.getPayment().getDescriptionPayment() + "\n" + 
									"Status: "+ registro.getStatus());
					System.out.println("");
				}				
			}String choice = getOptionMenu();
			runAction(choice);
		} else if (marca.equalsIgnoreCase("Santa Joana")) {
			List<Sale> allSales = facade.searchAllSales();

			for (Sale registro : allSales) {
				if (registro.getProduct().getDescriptionProduct().equalsIgnoreCase(marca)) {
					System.out.println(
							"ID: " + registro.getIdSale() + "\n" + 
									"NOME: " + registro.getClient().getNomeClient() + "\n" + 
									"CPF: " + registro.getClient().getCPF() + "\n" + 
									"Endereço: "+ registro.getClient().getAdress() + "\n" + 
									"Telefone: "+ registro.getClient().getTel() + "\n" + 
									"Marca: "+ registro.getProduct().getDescriptionProduct() + "\n" + 
									"Pagamento: "+ registro.getPayment().getDescriptionPayment() + "\n" + 
									"Status: "+ registro.getStatus());
					System.out.println("");
				}
			}String choice = getOptionMenu();
			runAction(choice);
		} else {
			List<Sale> allSales = facade.searchAllSales();

			for (Sale registro : allSales) {
				if (registro.getProduct().getDescriptionProduct().equalsIgnoreCase(marca)) {
					System.out.println(
							"ID: " + registro.getIdSale() + "\n" + 
									"NOME: " + registro.getClient().getNomeClient() + "\n" + 
									"CPF: " + registro.getClient().getCPF() + "\n" + 
									"Endereço: "+ registro.getClient().getAdress() + "\n" + 
									"Telefone: "+ registro.getClient().getTel() + "\n" + 
									"Marca: "+ registro.getProduct().getDescriptionProduct() + "\n" + 
									"Pagamento: "+ registro.getPayment().getDescriptionPayment() + "\n" + 
									"Status: "+ registro.getStatus());
					System.out.println("");
				}			
			}String choice = getOptionMenu();
			runAction(choice);
		} 

	}	   
	//OK
	public static void sairDoSistema() {
		System.out.println("SAINDO DO SISTEMA...");
		System.out.println("SISTEMA ENCERRADO!!!");
		System.exit(0);
	}

}
