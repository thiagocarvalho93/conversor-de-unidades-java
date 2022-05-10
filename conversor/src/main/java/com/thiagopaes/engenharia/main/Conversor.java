package com.thiagopaes.engenharia.main;

import java.util.function.BiFunction;

public class Conversor {

	private double fator1; // Fator de conversão 1
	private double fator2; // Fator de conversão 2
	private String nome1; // Nome da unidade 1
	private String nome2; // Nome da unidade 2
	private int firstIndex; // Primeiro índice da Grandeza física no Enum Unidade
	private int idGrandeza; // Índice da Grandeza física (Enum Grandeza)

	public void imprimeUnidade() {
		// Inicializa com alguma coisa
		Grandeza grandeza = Grandeza.DISTANCIA;
		// Imprime o nome da grandeza
		System.out.println(grandeza.filtraGrandeza(getIndiceGrandeza()).getNome());
		Util.printLine();

		// índice
		boolean isFirst = true;
		int indice = 0;
		// Imprime unidades
		for (Unidade u : Unidade.values()) {
			if (u.getGrandeza() == getIndiceGrandeza()) {
				if (isFirst) {
					setFirstIndex(u.ordinal());
					isFirst = false;
				}
				indice = u.ordinal() - getFirstIndex() + 1;
				System.out.print(indice + "-  " + u.getNome() + "  \t");
				if ((indice) % 4 == 0)
					System.out.print("\n");
			}
		}
	}

	private Unidade selecionaUnidade() {
		int opcao;
		Unidade v = Unidade.KMH;
		opcao = Util.validaInt("");

		v = v.filtraUnidade(opcao + getFirstIndex());
		if (v == null || v.getGrandeza() != getIndiceGrandeza()) {
			System.out.println("Opção inválida!");
			return selecionaUnidade();
		}
		return v;

	}

	public void entraDados() {
		Util.br();
		Util.printLine();
		System.out.print("Unidade antes da conversão: ");
		Unidade v1 = selecionaUnidade();
		setU1(v1.getFator());
		setNome1(v1.getNome());
		System.out.print("Unidade após conversão: ");
		Unidade v2 = selecionaUnidade();
		setU2(v2.getFator());
		setNome2(v2.getNome());
		Util.printLine();
		System.out.println(v1.getNome() + " -> " + v2.getNome());
	}

	public BiFunction<Double, Conversor, Double> converte = (x, gr) -> x * gr.getU2() / gr.getU1();

	public double converter(double num) {
		return converte.apply(num, this);
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public double getU1() {
		return fator1;
	}

	public void setU1(double u1) {
		this.fator1 = u1;
	}

	public double getU2() {
		return fator2;
	}

	public void setU2(double u2) {
		this.fator2 = u2;
	}

	public String getNome1() {
		return nome1;
	}

	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}

	public String getNome2() {
		return nome2;
	}

	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}

	public int getIndiceGrandeza() {
		return idGrandeza;
	}

	public void setIndiceGrandeza(int indiceGrandeza) {
		this.idGrandeza = indiceGrandeza;
	}

	public Conversor() {
	}

}
