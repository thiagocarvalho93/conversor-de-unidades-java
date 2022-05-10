package com.thiagopaes.engenharia.main;

import java.util.HashMap;
import java.util.Map;

public enum Grandeza {
	VELOCIDADE("Velocidade"), PRESSAO("Pressão"), TEMPERATURA("Temperatura"), PESO("Peso"), DISTANCIA("Distância");

	private static class Holder {
		static Map<Integer, Grandeza> GRANDEZA_MAP = new HashMap<>();
	}

	private String nome;

	private Grandeza(String nome) {
		this.nome = nome;
		Holder.GRANDEZA_MAP.put(this.ordinal() + 1, this);
	}

	public Grandeza filtraGrandeza(int n) {
		return Holder.GRANDEZA_MAP.get(n);
	}

	public String getNome() {
		return this.nome;
	}

}
