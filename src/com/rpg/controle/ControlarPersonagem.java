package com.rpg.controle;

import com.rpg.entidades.*;
import com.rpg.enums.Nomes;

public class ControlarPersonagem {
	public Personagem retornaPersonagem(Nomes nome) {
		// retorna um novo objeto conforme o nome que vem de entrada
		switch (nome) {
		case AQUAMAN:
			return new AquaMan();
		case BATMAN:
			return new Batman();
		case CORINGA:
			return new Coringa();
		case FLASH:
			return new Flash();
		case GIGANTA:
			return new Giganta();
		case LANTERNAVERDE:
			return new LaternaVerde();
		case LEXLUTHOR:
			return new LexLuthor();
		case LOBO:
			return new Lobo();
		case MULHERMARAVILHA:
			return new MulherMaravilha();
		case SINESTRO:
			return new Sinestro();
		case SUPERMAN:
			return new SuperMan();
		case VOLCANA:
			return new Volcana();
		default:
			nome.toString(nome);
			return null;
		}
	}

	public String chamaCarrega(Protagonista carrega, Personagem recebe) {
		// chama o metodo restaurar vida da classe protagonista
		String retorno = carrega.restaurarVida(carrega, recebe);
		return retorno;
	}

	public String retornaUrl(Personagem personagem) {
		// retorna o url da imagem que esta no pacote images conforme o nome do
		// personagem do parametro
		String nome = personagem.getNome();
		String url = "";
		switch (nome) {
		case "AquaMan":
			url = "/aquaman100x100.jpg";
			return url;
		case "Batman":
			url = "/batman100x100.jpg";
			return url;
		case "Coringa":
			url = "/coringa.jpg";
			return url;
		case "Flash":
			url = "/flash100x100.jpg";
			return url;
		case "Giganta":
			url = "/giganta100x100.jpg";
			return url;
		case "Lanterna Verde":
			url = "/lanterna100x100.jpg";
			return url;
		case "Lex Luthor":
			url = "/lex100x100.jpg";
			return url;
		case "Lobo":
			url = "/lobo100x100.jpg";
			return url;
		case "Mulher Maravilha":
			url = "/mulher100x100.jpg";
			return url;
		case "Sinestro":
			url = "/sinestro100x100.jpg";
			return url;
		case "Superman":
			url = "/superman100x100.jpg";
			return url;
		case "Volcana":
			url = "/volcana100x100.jpg";
			return url;
		default:
			return null;
		}
	}

}
