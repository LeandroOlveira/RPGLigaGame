package modeloEntidade;

public class Lobo extends Antagonista{

	public Lobo(){
		vida = 180;
		vidaParcial = vida;
		dano = 18;
		nome = "Lobo";
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
