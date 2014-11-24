package com.rpg.controle;
import java.util.ArrayList;
import java.util.List;

import com.rpg.entidades.*;
import com.rpg.enums.Nomes;
import com.rpg.utilitarios.Utilitarios;


public class ControlarEquipe {
	
	ControlarPersonagem ctrlP = new ControlarPersonagem();
	
	private static Equipe usuEquipe;
	private static Equipe maquinaEquipe;
	private static final int CHARS = 11; 
	
	public List<Personagem> getEquipe(){
		return usuEquipe.getEquipe();
	}
	
	public List<Personagem> getMaquina(){
		return maquinaEquipe.getEquipe();
	}
	
	private Equipe equipe(List<Personagem> personagens){
		return new Equipe(personagens);
	}
	
	public void criarEquipe(List<Nomes>personagens){
		//cria a lista com a equipe do usuario quando ele esolhe manualmente
		List<Personagem> novaEquipe = new ArrayList<Personagem>();
		for(Nomes nome : personagens){
			novaEquipe.add(ctrlP.retornaPersonagem(nome));
		}
		usuEquipe = equipe(novaEquipe);
		criarAleatorias(2);
	}
	
	public void criarAleatorias(int select){
		//cria uma equipe aleatoria confome uma lista de enumns criada aleatoriamente
		//o parametro serve para o switch, caso seja 1 ele cria a equipe do usuario
		// caso seja 2 cria a equipe da maquina
		List<Personagem> eqp = new ArrayList<Personagem>();
		List<Nomes>listaNomes = new ArrayList<Nomes>();
		Utilitarios util = new Utilitarios();
		for(int i = 0; i<3;i++){
			listaNomes.add(Nomes.getChar(util.getRandomInt(CHARS)));
		}
		 
		for(Nomes nome : listaNomes){
			eqp.add(ctrlP.retornaPersonagem(nome));
		}
		
		switch (select) {
		case 1:
			usuEquipe = equipe(eqp);
			break;
		case 2:
			maquinaEquipe = equipe(eqp);
		default:
			break;
		}
	}
	
	
}
