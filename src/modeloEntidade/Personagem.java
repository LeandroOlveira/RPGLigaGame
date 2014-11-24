package modeloEntidade;

import utilitarios.*;

public abstract class Personagem {
	protected String nome;
	protected double vida;
	protected double vidaParcial;
	protected int dano;
	protected String tipo;
	
	public String getTipo(){
		return tipo;
	}
	

	public abstract int atacar(Personagem atacado);
	
	
	
	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getResistencia(int reducao) {
		Utilitarios util = new Utilitarios();
		int resistencia = util.getRandomInt(reducao);
		return resistencia;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double quantidadeVida) {
		this.vida = quantidadeVida;
	}

	public double getVidaParcial() {
		return vidaParcial;
	}

	public void setVidaParcial(double vidaParcial) {
		this.vidaParcial = vidaParcial;
	}

	public String sofrerDano(int reducao){
		String msg;
		this.vidaParcial = this.vidaParcial - reducao;
		
		if(this.vidaParcial <= 0){
			msg = this.getNome()+" está morto !";
		}
		else if(reducao > 0){
			msg = this.getNome()+" Sofreu "+String.valueOf(reducao)+"\n\t de Dano !";
		}
		else{
			msg = this.getNome()+" Não sofreu dano !";
		}
		return msg;
	}

	
	public int reagir(int reducao){
		int saida;
		Utilitarios util = new Utilitarios();
		boolean defesa = util.getRandomBool();
		if(defesa==true){
			saida = util.getRandomInt(reducao);
			return saida;
		}
		else{
			return 0;
		}
	}
}
