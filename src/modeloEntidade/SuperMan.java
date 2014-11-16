package modeloEntidade;


public class SuperMan extends Antagonista  {
	
	public SuperMan(){
		super();
		vida = 200;
		vidaParcial = vida;
		dano = 20;
		nome = "Superman";
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
