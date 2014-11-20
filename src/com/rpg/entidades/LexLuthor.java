package com.rpg.entidades;


public class LexLuthor extends Antagonista{
	
	
	public LexLuthor(){
		super();
		vida=180;
		vidaParcial = vida;
		nome = "Lex Luthor";
		dano = 18;
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
