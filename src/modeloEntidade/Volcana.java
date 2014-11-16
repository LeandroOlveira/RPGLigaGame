package modeloEntidade;

public class Volcana extends Antagonista{

	public Volcana() {
		super();
		vida = 100;
		vidaParcial = vida;
		dano = 10;
		nome = "Volcana";
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
