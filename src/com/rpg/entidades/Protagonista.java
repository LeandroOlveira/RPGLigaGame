package com.rpg.entidades;


public abstract class Protagonista extends Personagem {
	protected double fatorIncremento;
	protected String tipo = "protagonista";
	
	public double getFatorIncremento() {
		return fatorIncremento;
	}

	public String getTipo() {
		return tipo;
	}

	public String restaurarVida(Protagonista prot, Personagem recebe){
		double  incremento = prot.getVida() * prot.getFatorIncremento();
		String retorno;
		if (recebe.getVida() > recebe.getVidaParcial()){
			recebe.setVidaParcial(recebe.getVidaParcial() + incremento);
		}
		else if (recebe.getVida() == recebe.getVidaParcial()){
			recebe.setVida(recebe.getVidaParcial() + incremento);
			recebe.setVidaParcial(recebe.getVida());
		}
		retorno = recebe.getNome()+" recebeu "+String.valueOf(incremento)+" de vida de "+prot.getNome();
		return retorno;
	}
	
	
	public int atacar (Personagem atacado){
		int saida = atacado.reagir(this.getDano());
		saida = this.getDano() - saida;
		return saida;
	}
	

	
}
