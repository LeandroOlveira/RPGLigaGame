package modeloEntidade;
import java.util.ArrayList;
import java.util.List;


public class Equipe {
	private List<Personagem> equipe = new ArrayList<Personagem>();
	
	public Equipe(List<Personagem> novaEqp){
		for(Personagem personagem : novaEqp){
			equipe.add(personagem);
		}
	}

	public List<Personagem> getEquipe() {
		return equipe;
	}
	
	public List<Personagem> deletePersonagem(int indice){
		this.equipe.remove(indice);
		return equipe;
	}


}
