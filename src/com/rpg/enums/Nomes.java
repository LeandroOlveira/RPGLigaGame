package com.rpg.enums;

public enum Nomes {
	LOBO("Protagonista"), SUPERMAN("Protagonista"), BATMAN("Protagonista"), FLASH(
			"Protagonista"), LEXLUTHOR("Protagonista"), VOLCANA("Protagonista"), MULHERMARAVILHA(
			"Antagonista"), LANTERNAVERDE("Antagonista"), AQUAMAN("Antagonista"), GIGANTA(
			"Antagonista"), CORINGA("Antagonista"), SINESTRO("Antagonista");

	String tipo;

	private Nomes(String tipo) {
		this.tipo = tipo;

	}

	public String toString(Nomes nome) {
		if (LOBO == nome) {
			return "Lobo";
		} else if (SUPERMAN == nome) {
			return "Superman";
		} else if (BATMAN == nome) {
			return "Batman";
		} else if (FLASH == nome) {
			return "Flash";
		} else if (LEXLUTHOR == nome) {
			return "Lex Luthor";
		} else if (VOLCANA == nome) {
			return "Volcana";
		} else if (MULHERMARAVILHA == nome) {
			return "Mulher Maravilha";
		} else if (LANTERNAVERDE == nome) {
			return "Lanterna Verde";
		} else if (AQUAMAN == nome) {
			return "Aquaman";
		} else if (GIGANTA == nome) {
			return "Giganta";
		} else if (CORINGA == nome) {
			return "Coringa";
		} else if (SINESTRO == nome) {
			return "Sinestro";
		}
		return null;
	}
	
	public static Nomes getChar(int select){
		switch (select) {
		case 0:
			return LOBO;
		case 1:
			return SUPERMAN;
		case 2:
			return BATMAN;
		case 3:
			return FLASH;
		case 4:
			return LEXLUTHOR;
		case 5:
			return VOLCANA;
		case 6:
			return MULHERMARAVILHA;
		case 7:
			return LANTERNAVERDE;
		case 8:
			return AQUAMAN;
		case 9:
			return GIGANTA;
		case 10:
			return CORINGA;
		case 11:
			return SINESTRO;			
		default:
			return null;
		}
	}
}
