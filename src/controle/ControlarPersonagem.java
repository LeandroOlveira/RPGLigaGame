package controle;

import modeloEntidade.*;
import enums.Nomes;

public class ControlarPersonagem{
	public Personagem retornaPersonagem(Nomes nome){
		//retorna um novo objeto conforme o nome que vem de entrada
		switch (nome) {	
		case AQUAMAN:
			return new AquaMan();
		case BATMAN:
			return new Batman();
		case CORINGA :
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
	
	public String chamaCarrega(Protagonista carrega, Personagem recebe){
		//chama o metodo restaurar vida da classe protagonista
		String retorno = carrega.restaurarVida(carrega.getVida(),carrega.getFatorIncremento(), recebe);
		return retorno;
	}
	
	public String retornaUrl(Personagem personagem){
		//retorna o url da imagem que esta no pacote images conforme o nome do personagem do parametro
		String nome = personagem.getNome();
		String url = "";
		switch (nome) {
		case "AquaMan":
			url = "/images/aquaman100x100.jpg";
			return url;
		case "Batman":
			url = "/images/batman100x100.jpg";
			return url;
		case "Coringa":
			url = "/images/coringa.jpg";
			return url;
		case"Flash" :
			url = "/images/flash100x100.jpg";
			return url;
		case "Giganta":
			url = "/images/giganta100x100.jpg";
			return url;
		case "Lanterna Verde":
			url = "/images/lanterna100x100.jpg";
			return url;
		case "Lex Luthor":
			url = "/images/lex100x100.jpg";
			return url;
		case "Lobo":
			url = "/images/lobo100x100.jpg";
			return url;
		case "Mulher Maravilha":
			url = "/images/mulher100x100.jpg";
			return url;
		case "Sinestro":
			url = "/images/sinestro100x100.jpg";
			return url;
		case "Superman":
			url = "/images/superman100x100.jpg";
			return url;
		case "Volcana":
			url = "/images/volcana100x100.jpg";
			return url;
		default:
			return null;
		}
	}

}
