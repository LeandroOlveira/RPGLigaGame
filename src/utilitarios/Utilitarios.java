package utilitarios;

import java.util.*;

import modeloEntidade.*;
public class Utilitarios {

	public boolean getRandomBool(){
		//retorna verdadeiro ou falso aleatoriamente
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public int getRandomInt(int intervaloVaria){
		Random random = new Random();
		//retorna valores pseudo aleatórios de 0 ate o valor passado como parametro
		return random.nextInt(intervaloVaria + 1);
	}


}

