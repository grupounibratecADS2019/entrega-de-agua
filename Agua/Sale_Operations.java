package br.edu.unibratec.entregadeagua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.edu.unibratec.entregadeagua.interfaces.WaterInterface;
import br.edu.unibratec.entregadeagua.model.Sale;


public class Sale_Operations {
	
   /* Gmail e GitHub
	  grupounibratec@gmail.com
	  Grup0@un1br4t3c

	private long limite() {

		long calculo = 0;

		long tempoEmMinutos = 10;

		calculo = (tempoEmMinutos * 60) * 1000;

		return calculo;
	}


	private void listarPorMarcaDeAgua() {

		String marcaDeAgua = exibirMarcas();

		if (marcaDeAgua == "Indaiá") {

			for (Sale marcaAgua : Sales) {
				if (marcaAgua.getBrand().equals(marcaDeAgua)) {
					System.out.println("===============");
					System.out.println("Nome: " + marcaAgua.getNome());
					System.out.println("Marca: " + marcaAgua.getBrand());
					System.out.println("Endereço: " + marcaAgua.getAdress());
					System.out.println("Forma de Pagamento: " + marcaAgua.getFormPayment());
					System.out.println("Status: " + marcaAgua.getStatus());
					System.out.println("===============");
				}
			}
		} else if (marcaDeAgua == "Santa Joana") {

			for (Sale marcaAgua : Sales) {
				if (marcaAgua.getFormPayment().equals(marcaDeAgua)) {
					System.out.println("===============");
					System.out.println("Nome: " + marcaAgua.getNome());
					System.out.println("Marca: " + marcaAgua.getBrand());
					System.out.println("Endereço: " + marcaAgua.getAdress());
					System.out.println("Forma de Pagamento: " + marcaAgua.getFormPayment());
					System.out.println("Status: " + marcaAgua.getStatus());
					System.out.println("===============");
				}
			}
		} else {
			marcaDeAgua = "Santa Clara";
			for (Sale marcaAgua : Sales) {
				if (marcaAgua.getFormPayment().equals(marcaDeAgua)) {
					System.out.println("===============");
					System.out.println("Nome: " + marcaAgua.getNome());
					System.out.println("Marca: " + marcaAgua.getBrand());
					System.out.println("Endereço: " + marcaAgua.getAdress());
					System.out.println("Forma de Pagamento: " + marcaAgua.getFormPayment());
					System.out.println("Status: " + marcaAgua.getStatus());
					System.out.println("===============");
				}
			}
		}

	}

	private int listaCancel(){

		for (Sale vendasTotal : Sales) {
			System.out.println();
			System.out.println("================================");
			System.out.println();
			System.out.println("ID: " + vendasTotal.getIDSale()+" <--- DIGITE NÚMERO INTEIROS PARA CANCELAR");
			System.out.println("Nome: " + vendasTotal.getNome());
			System.out.println();
			System.out.println("================================");
			System.out.println();
		}

		System.out.println("Qual ID deseja Cancelar?");
		int opcao = teclado.nextInt();

		int indexArray = 0;
		for (int i = 0; i < Sales.size(); i++) {
			if(Sales.get(i).getIDSale() == opcao){
				indexArray = i;
			}else{
				System.out.println("ID inválido");
				listaCancel();
			}
		}
		return indexArray;
	}

	private void editSale(Sale venda) {
		System.out.println("FUNÇÃO SENDO IMPLEMENTADA");
	}


}
