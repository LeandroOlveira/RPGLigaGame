package com.rpg.controle;

import java.util.ArrayList;
import java.util.List;

import com.rpg.controle.ControlarEquipe;
import com.rpg.entidades.Personagem;
import com.rpg.entidades.Protagonista;
import com.rpg.utilitarios.Utilitarios;

public class ControlarPartida {
	private List<Personagem> usuqEquipe = new ArrayList<Personagem>();
	private List<Personagem> maqEquipe = new ArrayList<Personagem>();
	private ControlarEquipe ce = new ControlarEquipe();
	private ControlarPersonagem cp = new ControlarPersonagem();
	private Utilitarios util = new Utilitarios();
	private ArrayList<Integer> mortosMaq = new ArrayList<Integer>();
	private ArrayList<Integer> mortosUsu = new ArrayList<Integer>();
	private int tamanhoMaq = 2;
	private int tamanhoUsu = 2;

	public ArrayList<Integer> getMortosUsu() {
		return mortosUsu;
	}

	public void setMortosUsu(int morto) {
		mortosUsu.add(morto);
	}

	public int getTamanho() {
		return tamanhoMaq;
	}

	public void setMortos(int morto) {
		mortosMaq.add(morto);
	}

	public ArrayList<Integer> getMortos() {
		return mortosMaq;
	}

	public void setTamanho(int tamanho) {
		this.tamanhoMaq = tamanho;
	}

	public List<Personagem> getUsuqEquipe() {
		return usuqEquipe;
	}

	public List<Personagem> getMaqEquipe() {
		return maqEquipe;
	}

	public boolean verificarTipo(Personagem personagem) {
		// verifica se o personagem é protagonista ou antagonista
		if (personagem.getTipo() == "protagonista") {
			return true;
		} else {
			return false;
		}
	}

	public void organizarEqp() {
		// as listas de equipes recebem as listas que vem do controlador de
		// equipes
		usuqEquipe = ce.getEquipe();
		maqEquipe = ce.getMaquina();
	}

	public int atacar(int atacando, int atacado) {
		// metodo atacar simples, é usado somente pelo usuario
		int reducao;
		reducao = usuqEquipe.get(atacando).atacar(maqEquipe.get(atacado));
		return reducao;
	}

	public String atacarMaq() {
		// metodo atacar usado pela maquina
		int reducao, index = -1, atacado;
		String retorno = "";
		boolean escolheAcao = util.getRandomBool(); // escolhe aleatoriamente se
													// a acao a ser realizada
													// vai ser atacar ou
													// restaurar vida
		index = util.getRandomInt(tamanhoMaq); // escolhe o personagem que vai
												// atacar
		atacado = util.getRandomInt(tamanhoUsu);
		if (mortosMaq.size() >= 4 || mortosUsu.size() >= 4) {
			return null;
		}
		while (maqEquipe.get(index).isMorto()) {
			index = util.getRandomInt(tamanhoMaq);
		}
		while (usuqEquipe.get(atacado).isMorto()) {
			atacado = util.getRandomInt(tamanhoUsu);
		}
		if (escolheAcao) {
			if (usuqEquipe.get(atacado).isMorto()) {
				retorno = "Pesonagem atacado ja está moto";
				return retorno;
			}
			reducao = maqEquipe.get(index).atacar(usuqEquipe.get(atacado)); // realiza
																			// o
																			// ataque
																			// se
																			// escolheAcao
																			// ==
																			// true
			retorno = usuqEquipe.get(atacado).sofrerDano(reducao,
					maqEquipe.get(index));
		} else { // senao ele chama o metodo que regenera vida
			retorno = restaurarMaq();
		}
		return retorno;
	}

	public String restaurarMaq() { // metodo que regenera vida
		int reducao, recebe = -1;
		int index = util.getRandomInt(tamanhoMaq);
		String retorno = "";

		while (maqEquipe.get(index).isMorto()) {
			index = util.getRandomInt(tamanhoMaq);
		}

		if (index == 2 || index == 1) {
			recebe = index - 1;
		} else if (index == 0) { // escolhe qual personagem vai receber vida (ta
									// ultraMegaFucking bugado quando tem
									// personagem morto)
			recebe = index + 2;
		}
		if (verificarTipo(maqEquipe.get(index))) { // verifica se o personagem
													// que gerou é protagonista,
													// senao ele ataca
			if (maqEquipe.get(recebe).isMorto()) {
				retorno = "Este personagem esta morto !";
				return retorno;
			} else {
				retorno = restaurarVida(maqEquipe.get(index),
						maqEquipe.get(recebe));
			}
		} else {
			reducao = maqEquipe.get(util.getRandomInt(tamanhoMaq)).atacar(
					usuqEquipe.get(tamanhoUsu));
			retorno = usuqEquipe.get(index).sofrerDano(reducao,
					maqEquipe.get(index));
		}
		return retorno;

	}

	public String restaurarVida(Personagem personagem, Personagem recebe) { // restaura
																			// vida
																			// simples
		String retorno = cp.chamaCarrega((Protagonista) personagem, recebe);
		return retorno;
	}

}
