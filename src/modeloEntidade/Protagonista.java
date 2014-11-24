package modeloEntidade;


public abstract class Protagonista extends Personagem {
	protected double fatorIncremento;
	protected String tipo = "protagonista";
	
	public double getFatorIncremento() {
		return fatorIncremento;
	}

	public String getTipo() {
		return tipo;
	}

	public String restaurarVida(double vidaPersonagem, double fatorIncremento, Personagem recebe){
		double  incremento = vidaPersonagem * fatorIncremento;
		String retorno;
		if (recebe.getVida() > recebe.getVidaParcial()){
			recebe.setVidaParcial(recebe.getVidaParcial() + incremento);
		}
		else if (recebe.getVida() == recebe.getVidaParcial()){
			recebe.setVida(recebe.getVidaParcial() + incremento);
			recebe.setVidaParcial(recebe.getVida());
		}
		retorno = recebe.getNome()+" recebeu "+String.valueOf(incremento)+" de vida !";
		return retorno;
	}
	
	
	public int atacar (Personagem atacado){
		int saida = atacado.reagir(this.getDano());
		saida = this.getDano() - saida;
		return saida;
	}
	

	
}
