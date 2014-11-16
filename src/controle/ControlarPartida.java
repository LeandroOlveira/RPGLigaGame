package controle;



import java.util.ArrayList;
import java.util.List;


import utilitarios.Utilitarios;
import modeloEntidade.Equipe;
import modeloEntidade.Personagem;
import modeloEntidade.Protagonista;
import controle.ControlarEquipe;


public class ControlarPartida {
	private static List<Personagem> usuqEquipe = new ArrayList<Personagem>();
	private static List<Personagem> maqEquipe = new ArrayList<Personagem>();
	private ControlarEquipe ce = new ControlarEquipe();
	private ControlarPersonagem cp = new ControlarPersonagem();
	private Utilitarios util = new Utilitarios();
	private ArrayList<Integer> mortos = new ArrayList<Integer>();
	private int tamanhoMaq = 2;
	private int tamanhoUsu = 2;
	
	public int getTamanho() {
		return tamanhoMaq;
	}

	public void setMortos(int morto){
		mortos.add(morto);
	}
	
	public void setTamanho(int tamanho) {
		this.tamanhoMaq = tamanho;
	}


	public static List<Personagem> getUsuqEquipe() {
		return usuqEquipe;
	}


	public static  List<Personagem> getMaqEquipe() {
		return maqEquipe;
	}

	public boolean verificarTipo(Personagem personagem){
		//verifica se o personagem é protagonista ou antagonista
		if(personagem.getTipo()=="protagonista"){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void organizarEqp(){
		//as listas de equipes recebem as listas que vem do controlador de equipes
		usuqEquipe = ce.getEquipe();
		maqEquipe = ce.getMaquina();
	}
	
	public int atacar(int atacando, int atacado){
		//metodo atacar simples, é usado somente pelo usuario
		int reducao;
		reducao = usuqEquipe.get(atacando).atacar(maqEquipe.get(atacado));
		return reducao;
	}
	
	
	public String atacarMaq(){
		//metodo atacar usado pela maquina
		int reducao,index = -1,atacado, naoPode;
		String retorno = "";
		boolean escolheAcao = util.getRandomBool(); // escolhe aleatoriamente se a acao a ser realizada vai ser atacar ou restaurar vida
		index = util.getRandomInt(tamanhoMaq);  //escolhe o personagem que vai atacar
		atacado = util.getRandomInt(tamanhoUsu);
		if(mortos.size()!= 1){ // esse if verifica se o personagem selecionado para atacar nao esta morto, atraves de uma arraylist auxiliar
			naoPode = mortos.get(1);
			for(int i = 0; i<mortos.size();i++){
				if((mortos.get(i) != index ) && (index != naoPode)){   //se o index for diferente do elemento selecionado da lista ele continua o laço
					continue;
				}else{										 // senao ele gera um novo (nao foi muito inteligente, visto que ele pode gerar o mesmo numero novamente...
					while((mortos.get(i) == index)||(index == naoPode)) {// ... pode nao ter sido a escolha mais otimizada em questao de processamento, mas foi a melhor que eu ...
						index = util.getRandomInt(tamanhoMaq);			// consegui pensar.)
					}
																	
				}
			}
		}
		if(escolheAcao){
			reducao = maqEquipe.get(index).atacar(usuqEquipe.get(atacado)); //realiza o ataque se escolheAcao == true
			retorno = usuqEquipe.get(atacado).sofrerDano(reducao);
		}
		else{                                //senao ele chama o metodo que regenera vida
			retorno = restaurarMaq();
		}
		return retorno;
	}
	
	public String restaurarMaq(){  // metodo que regenera vida
		int reducao, recebe = -1, naoPode;
		int index = util.getRandomInt(tamanhoMaq);
		String retorno ="";
		
		if(mortos.size() != 1){
			naoPode = mortos.get(1);
			for(int i = 0; i<mortos.size();i++){								//mesma coisa do metodo anterior
				if((mortos.get(i) != index) && (index != naoPode)){
					continue;
				}else{
					while((mortos.get(i) == index)||(index == naoPode)){
						index = util.getRandomInt(tamanhoMaq);
					}	
				}
			}
		}

		if(index == 2 || index == 1){
			recebe = index -1;
		}else if(index == 0 ){	// escolhe qual personagem vai receber vida (ta ultraMegaFucking bugado quando tem personagem morto)
			recebe = index +2;
		}
		if(verificarTipo(maqEquipe.get(index))){          // verifica se o personagem que gerou é protagonista, senao ele ataca
			retorno = restaurarVida(maqEquipe.get(index),maqEquipe.get(recebe));
		}
		else{
			reducao = maqEquipe.get(util.getRandomInt(tamanhoMaq)).atacar(usuqEquipe.get(tamanhoUsu));
			retorno = usuqEquipe.get(index).sofrerDano(reducao);
		}
		return retorno;
			
	}
		
	
	public String restaurarVida(Personagem personagem,Personagem recebe){  // restaura vida simples
		String retorno = cp.chamaCarrega((Protagonista)personagem, recebe);
		return retorno;
	}

}
