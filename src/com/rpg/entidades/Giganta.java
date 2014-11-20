package com.rpg.entidades;

public class Giganta extends Protagonista{
	
	public Giganta(){
		super();
		vida = 100;
		vidaParcial = vida;
		dano = 10;
		nome = "Giganta";
		tipo = "protagonista";
		fatorIncremento = 0.25;
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
