package br.edu.unibratec.entregadeagua.util;

import br.edu.unibratec.entregadeagua.view.Menu;

public class VendaValidator {

	public static void validName(String nome) {
		if (!(nome.trim().matches("^[A-Z a-zÀ-Åà-åÈ-Ëè-ëÌ-Ïì-ïÒ-Öò-öÙ-Üù-üÇçÑñÝý\\\\s]{3,100}$"))  || nome == null || nome == "" || nome.isEmpty() == true) {
			System.out.println("Nome: "+nome+"  inválido!!!");
			System.out.println("Tente novamente...\n");
			Menu.runAction(Menu.getOptionMenu());
		}
	}

	public static void validCPF(String CPF) {
		
		if (CPF.trim().matches("^[a-zA-Z]+$") || !(CPF.trim().matches("^[0-9]+$")) || CPF == null || CPF == "" || CPF.isEmpty() == true
				|| !(CPF.trim().length() == 11)) {
			System.out.println("CPF: "+CPF+" inválido!!!");
			System.out.println("Tente novamente...\n");
			Menu.runAction(Menu.getOptionMenu());
		}
		
	}
	
	public static void validEndereco(String endereco) {
		if (!(endereco.trim().matches("^[0-9 A-Za-zÀ-Åà-åÈ-Ëè-ëÌ-Ïì-ïÒ-Öò-öÙ-Üù-üÇçÑñÝý\\\\s.,-]{3,}+$")) || endereco == null || endereco == "" || endereco.isEmpty() == true) {
			System.out.println("Endereço: "+endereco+"  inválido!!!");
			System.out.println("Tente novamente...\n");
			Menu.runAction(Menu.getOptionMenu());
			}
	}
	
	public static void validTel(String tel) {
		if(!(tel.trim().matches("^[0-9()-]{9,}$")) || tel == null || tel == "" || tel.isEmpty() == true) {
			System.out.println("Telefone: " +tel+ " inválido!!!");
			System.out.println("Tente novamente...\n");
			Menu.runAction(Menu.getOptionMenu());
		}
	}

}
