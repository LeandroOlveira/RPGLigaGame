package com.rpg.entidades;

public class LaternaVerde extends Protagonista{ 
	
	public LaternaVerde(){
		super();
		vida = 130;
		vidaParcial = vida;
		dano = 13;
		nome = "Lanterna Verde";
		fatorIncremento = 0.3;
		tipo = "protagonista";
	}
	
	@Override
	public String toString(){
		return "nome: " + nome + "\n" 
			  +"Quantidade de Vida: " + vida + "\n"
			  +"Poder de Dano: " + dano + "\n\n";
	}


	@Override
	public int getDano() {
		return dano;
	}


		

}
