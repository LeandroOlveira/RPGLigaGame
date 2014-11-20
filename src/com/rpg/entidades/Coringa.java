package com.rpg.entidades;

public class Coringa extends Protagonista{

	public Coringa(){
		super();
		vida = 150;
		vidaParcial = vida;
		dano =15;
		nome = "Coringa";
		tipo = "antagonista";
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
