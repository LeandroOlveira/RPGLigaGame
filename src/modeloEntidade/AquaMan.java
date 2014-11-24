package modeloEntidade;

public class AquaMan extends Protagonista{
	
	public AquaMan(){
		vida = 50;
		vidaParcial = vida;
		nome = "AquaMan";
		dano = 5;
		fatorIncremento = 0.2;
		tipo = "protagonista";
	}
	
	@Override
	public String toString(){
		return nome + "\n" 
			  + vida + "\n"
			  + dano;
	}
	
	@Override
	public int getDano() {
		return dano;
	}

}