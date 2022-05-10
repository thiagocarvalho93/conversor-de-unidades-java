package com.thiagopaes.engenharia.main;

import java.text.DecimalFormat;

public class Menu {

	public static final Grandeza grandeza = Grandeza.DISTANCIA;
	public static final Unidade unidade = Unidade.ATM;

	public static void menuInicial() {
		System.out.println("CONVERSOR DE UNIDADES");
		Util.printLine();

		// Impress�o das op��es
		for (Grandeza g : Grandeza.values()) {
			System.out.print(g.ordinal() + 1 + "- " + g.getNome() + "  \t");
			if ((g.ordinal() + 1) % 4 == 0)
				System.out.print("\n");
		}
		Util.br();
		Util.printLine();

		// Seleciona a grandeza
		Grandeza g;
		byte opcao;
		do {
			opcao = Util.validaByte("Selecione a op��o: ");
			g = grandeza.filtraGrandeza(opcao);
		} while (g == null);

		Util.printLine();
		// Pega o �ndice correspondente da grandeza escolhida
		menuGrandeza(opcao);
	}

	private static void menuGrandeza(int indiceGrandeza) {
		Conversor conversor = new Conversor();
		conversor.setIndiceGrandeza(indiceGrandeza);
		conversor.imprimeUnidade();

		// Insere as unidades
		conversor.entraDados();

		// Insere o valor e calcula o resultado
		double valor = Util.validaDouble("Entre o valor a ser convertido: ");

		// Convers�o
		double resultado = conversor.converter(valor);

		// Imprime Resultados
		DecimalFormat d = new DecimalFormat("#,##0.0"); // Formata��o
		d.setMaximumFractionDigits(6);
		System.out.printf("%s %s = %s %s. \n", d.format(valor), conversor.getNome1(), d.format(resultado),
				conversor.getNome2());

		if (menuContinua())
			menuGrandeza(indiceGrandeza);
		else
			menuInicial();
	}

	private static boolean menuContinua() {
		Util.printLine();
		System.out.println("1- Converter novamente");
		System.out.println("2- Menu inicial");
		byte opcao = Util.validaByte("Escolha a op��o: ");
		switch (opcao) {
		case 1:
			return true;
		case 2:
			return false;
		default:
			System.out.println("Op��o inv�lida!");
			return menuContinua();
		}
	}

}
