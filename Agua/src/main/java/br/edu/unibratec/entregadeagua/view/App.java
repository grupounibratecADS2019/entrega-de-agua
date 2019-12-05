package br.edu.unibratec.entregadeagua.view;

public class App {
	public static void main(String[] args) {
		try {

			Menu menu = new Menu();
			menu.headSystem();
			String option = Menu.getOptionMenu();
			Menu.runAction(option);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
