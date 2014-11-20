package com.rpg.entidades;

public class Sinestro extends Protagonista{;
	
	public Sinestro(){
		super();
		vida = 105;
		vidaParcial = vida;
		dano = 10;
		nome = "Sinestro";
		fatorIncremento = 0.5;
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
