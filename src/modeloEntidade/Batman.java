package modeloEntidade;


public class Batman extends Antagonista {

	
	public Batman(){
		super();
		vida = 210;
		vidaParcial = vida;
		nome = "Batman";
		dano = 21;
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
