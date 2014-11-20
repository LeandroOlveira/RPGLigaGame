package com.rpg.entidades;

public class MulherMaravilha extends Protagonista{ 
	
	public MulherMaravilha(){
		super();
		vida = 100;
		vidaParcial = vida;
		dano = 10;
		nome = "Mulher Maravilha";
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
