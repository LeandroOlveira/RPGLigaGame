package com.rpg.entidades;

import com.rpg.utilitarios.Utilitarios;

public abstract class Antagonista extends Personagem {
	protected static int PODER_ATAQUE = 2;
	

	@Override
	public int atacar (Personagem atacado) {
		boolean dobra;
		int saida;
		Utilitarios util = new Utilitarios();
		dobra = util.getRandomBool();
		if(dobra){
			saida = atacado.reagir(this.getDano()*PODER_ATAQUE);
			saida = this.getDano()*PODER_ATAQUE - saida  ;
			return saida;
		}
		else{
			saida = atacado.reagir(this.getDano());
			saida = this.getDano() - saida;
			return saida;
		}
	}
	
}
