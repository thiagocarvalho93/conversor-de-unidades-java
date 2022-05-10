package com.thiagopaes.engenharia.main;

import java.util.HashMap;
import java.util.Map;

public enum Unidade {
	// VELOCIDADE
	KMH(1, "km/h", 1), MPH(0.621371, "mph", 1), MPS(1 / 3.6, "m/s", 1),
	// PRESSÃO
	PA(1, "Pa", 2), MPA(Math.pow(10, -6), "MPa", 2), BAR(Math.pow(10, -5), "Bar", 2),
	KGFCM(1.02 * Math.pow(10, -5), "kg/cm²", 2), KPA(Math.pow(10, -3), "kPa", 2), KGFM(0.1, "kgf/m²", 2),
	ATM(9.87 * Math.pow(10, -6), "Atm", 2), KSI(1.45 * Math.pow(10, -4), "ksi", 2),
	PSI(1.45 * Math.pow(10, -7), "psi", 2), PSF(0.02, "psf", 2), MH20(1.02 * Math.pow(10, -4), "mH2O", 2),
	CMH2O(0.01, "cmH2O", 2), FTH2O(3.35 * Math.pow(10, -4), "ftH2O", 2), INH2O(4.01 * Math.pow(10, -3), "inH2O", 2),
	MMHG(0.01, "mmHg", 2), CMHG(7.5 * Math.pow(10, -4), "cmHg", 2), TORR(0.01, "torr", 2),
	// PESO
	MG(Math.pow(10, -3), "mg", 4), G(1, "g", 4), KG(1000, "kg", 4), TON(Math.pow(10, 6), "ton", 4),
	OZ(28.34952313, "oz", 4), LB(453.59237, "lb", 4),
	// DISTÂNCIA
	M(1, "m", 5), KM(1000, "KM", 5);

	private static class Holder {
		static Map<String, Unidade> NOME_MAP = new HashMap<>();
		static Map<Integer, Unidade> GRANDEZA_MAP = new HashMap<>();
		static Map<Integer, Unidade> INDEX_MAP = new HashMap<>();
	}

	private final double fator;
	private final String nome;
	private final int grandeza;

	public int getGrandeza() {
		return grandeza;
	}

	private Unidade(double fator, String nome, int grandeza) {
		this.fator = fator;
		this.nome = nome;
		this.grandeza = grandeza;
		Holder.GRANDEZA_MAP.put(grandeza, this);
		Holder.INDEX_MAP.put(this.ordinal() + 1, this);
	}

	public String getNome() {
		return this.nome;
	}

	public double getFator() {
		return this.fator;
	}

	public Unidade filtraGrandeza(int num) {
		return Holder.GRANDEZA_MAP.get(num);
	}

	public Unidade filtraUnidade(int index) {
		return Holder.INDEX_MAP.get(index);
	}

	public Unidade filtraNome(String nome) {
		return Holder.NOME_MAP.get(nome);
	}

}
