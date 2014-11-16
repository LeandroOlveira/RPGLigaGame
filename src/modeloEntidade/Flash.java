package modeloEntidade;


public class Flash extends Antagonista{

	public Flash(){
		super();
		nome = "Flash";
		vida = 150;
		vidaParcial = vida;
		dano = 15;
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
