package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;

import controle.ControlarPartida;
import controle.ControlarPersonagem;
import modeloEntidade.Personagem;
import modeloEntidade.Protagonista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Panel;

import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import java.awt.FlowLayout;

public class InterfaceJogo extends JFrame implements ActionListener {
	private JFrame frame;
	private JPanel contentPane;
	private JPanel panelEqpUser;
	private JPanel char1;
	private JButton btnAtacar1;
	private JButton btnRestaurar1;
	private JPanel char2;
	private JButton btnAtacar2;
	private JButton btnRestaurar2;
	private JPanel char3;
	private JButton btnAtacar3;
	private JButton btnRestaurar3;
	private JProgressBar hp1;
	private JProgressBar hp2;
	private JProgressBar hp3;
	private JPanel panelEqpMaq;
	private JPanel maq1;
	private JProgressBar hpMaq1;
	private JPanel maq2;
	private JProgressBar hpMaq2;
	private JPanel maq3;
	private JProgressBar hpMaq3;
	private ControlarPartida cp = new ControlarPartida();
	private static List<Personagem> usuEqp = new ArrayList<Personagem>();
	private static List<Personagem> maqEqp = new ArrayList<Personagem>();
	private JPanel panelFeedback;
	private JLabel labelFeedback;
	private JButton btnReceberVida1;
	private JButton btnReceberVida2;
	private JButton btnReceberVida3;
	private int index = 0;
	private int indexAtaque = 0;
	private JLabel lblBattlelogSuas;
	private JPanel panelFeedback2;
	private JLabel lblBattlelogAes;
	private JLabel labelFeedback2;
	private JButton btnSelecionar1;
	private JButton btnSelecionar2;
	private JButton btnSelecionar3;
	private JPanel panelMaqBtn1;
	private JPanel panelMaqBtn2;
	private JPanel panelMaqBtn3;
	private JLabel foto2;
	private JLabel foto3;
	private JLabel foto1;
	private JLabel fotoMaq1;
	private JLabel fotoMaq2;
	private JLabel fotoMaq3;
	
	public InterfaceJogo() {
		Inicializar();
	}
	
	private void Inicializar() {
		
		cp.setMortos(-1);
		cp.organizarEqp();
		organizarEqp();
		
		frame = new JFrame("Batalha");
		frame.setBounds(100,100,849,550);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		panelEqpUser = new JPanel();
		panelEqpUser.setBounds(10, 302, 823, 189);
		frame.getContentPane().add(panelEqpUser);
		panelEqpUser.setLayout(null);
		
		char1 = new JPanel();
		char1.setBounds(10, 47, 122, 131);
		panelEqpUser.add(char1);
		char1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		foto1 = new JLabel("");
		char1.add(foto1);
			
		btnAtacar1 = criaBtn(panelEqpUser, 142, 79, 100, 23, "Atacar 1");;
		btnAtacar1.addActionListener(this);
		
		btnRestaurar1 = criaBtn(panelEqpUser, 142, 113, 100, 23, "Restaurar 1");
		btnRestaurar1.addActionListener(this);
		
		btnReceberVida1 = criaBtn(panelEqpUser, 142, 147, 100, 23, "Receber Vida 1");
		btnReceberVida1.setEnabled(false);
		btnReceberVida1.addActionListener(this);
		
		char2 = new JPanel();
		char2.setBounds(281, 47, 122, 131);
		panelEqpUser.add(char2);
		
		foto2 = new JLabel("");
		char2.add(foto2);
				
		btnAtacar2 = criaBtn(panelEqpUser, 413, 79, 99, 23, "Atacar 2");
		btnAtacar2.addActionListener(this);
		
		btnRestaurar2 = criaBtn(panelEqpUser, 413, 113, 99, 23, "Restaurar 2");
		btnRestaurar2.addActionListener(this);
		
		char3 = new JPanel();
		char3.setBounds(561, 47, 122, 131);
		panelEqpUser.add(char3);
		
		foto3 = new JLabel("");
		char3.add(foto3);
				
		btnAtacar3 = criaBtn(panelEqpUser, 693, 79, 95, 23, "Atacar 3");
		btnAtacar3.addActionListener(this);
		
		btnRestaurar3 = criaBtn(panelEqpUser, 693, 113, 95, 23, "Restaurar 3");
		btnRestaurar3.addActionListener(this);
		
		hp1 = new JProgressBar();
		hp1.setStringPainted(true);
		hp1.setForeground(Color.GREEN);
		hp1.setBounds(10, 23, 122, 20);
		preencherLife(hp1, usuEqp.get(0));
		panelEqpUser.add(hp1);
		
		hp2 = new JProgressBar();
		hp2.setStringPainted(true);
		hp2.setForeground(Color.GREEN);
		hp2.setBounds(281, 23, 122, 20);
		preencherLife(hp2, usuEqp.get(0));
		panelEqpUser.add(hp2);
		
		hp3 = new JProgressBar();
		hp3.setStringPainted(true);
		hp3.setForeground(Color.GREEN);
		preencherLife(hp2, usuEqp.get(1));
		hp3.setBounds(561, 23, 122, 20);
		panelEqpUser.add(hp3);
		
		panelEqpMaq = new JPanel();
		panelEqpMaq.setBounds(10, 11, 823, 183);
		frame.getContentPane().add(panelEqpMaq);
		preencherLife(hp3, usuEqp.get(2));
		
		btnReceberVida2 = criaBtn(panelEqpUser, 413, 147, 102, 23, "Receber Vida 2");
		btnReceberVida2.setEnabled(false);
		btnReceberVida2.addActionListener(this);
		
		btnReceberVida3 = criaBtn(panelEqpUser, 693, 147, 102, 23, "Receber Vida 3");
		btnReceberVida3.setEnabled(false);
		btnReceberVida3.addActionListener(this);
		
		panelEqpMaq.setLayout(null);
		
		maq1 = new JPanel();
		maq1.setBounds(10, 11, 122, 131);
		panelEqpMaq.add(maq1);
		
		fotoMaq1 = new JLabel("");
		maq1.add(fotoMaq1);
		
		hpMaq1 = new JProgressBar();
		hpMaq1.setStringPainted(true);
		hpMaq1.setForeground(Color.GREEN);
		preencherLife(hpMaq1, maqEqp.get(0));
		hpMaq1.setBounds(10, 153, 122, 19);
		panelEqpMaq.add(hpMaq1);
		
		maq2 = new JPanel();
		maq2.setBounds(288, 11, 122, 131);
		panelEqpMaq.add(maq2);
		
		fotoMaq2 = new JLabel("");
		maq2.add(fotoMaq2);
		
		hpMaq2 = new JProgressBar();
		hpMaq2.setStringPainted(true);
		hpMaq2.setForeground(Color.GREEN);
		hpMaq2.setBounds(288, 153, 122, 19);
		preencherLife(hpMaq2,maqEqp.get(1));
		panelEqpMaq.add(hpMaq2);
		
		maq3 = new JPanel();
		maq3.setBounds(563, 11, 122, 131);
		panelEqpMaq.add(maq3);
		
		fotoMaq3 = new JLabel("");
		maq3.add(fotoMaq3);
		
		hpMaq3 = new JProgressBar();
		hpMaq3.setStringPainted(true);
		hpMaq3.setForeground(Color.GREEN);
		preencherLife(hpMaq3, maqEqp.get(2));
		hpMaq3.setBounds(563, 153, 122, 19);
		panelEqpMaq.add(hpMaq3);
		
		panelMaqBtn1 = new JPanel();
		panelMaqBtn1.setBounds(137, 29, 112, 97);
		panelEqpMaq.add(panelMaqBtn1);
		panelMaqBtn1.setLayout(null);
		
		btnSelecionar1 = criaBtn(panelMaqBtn1, 0, 28, 112, 35, "Selecionar 1");
		btnSelecionar1.setEnabled(false);
		btnSelecionar1.addActionListener(this);
		
		panelMaqBtn2 = new JPanel();
		panelMaqBtn2.setBounds(420, 29, 122, 97);
		panelEqpMaq.add(panelMaqBtn2);
		panelMaqBtn2.setLayout(null);
		
		btnSelecionar2 = criaBtn(panelMaqBtn2, 0, 29, 112, 35, "Selecionar 2");
		btnSelecionar2.setEnabled(false);
		btnSelecionar2.addActionListener(this);
		
		panelMaqBtn3 = new JPanel();
		panelMaqBtn3.setBounds(695, 29, 122, 97);
		panelEqpMaq.add(panelMaqBtn3);
		panelMaqBtn3.setLayout(null);
		
		btnSelecionar3 = criaBtn(panelMaqBtn3, 0, 28, 112, 35, "Selecionar 3");
		btnSelecionar3.setEnabled(false);
		btnSelecionar3.addActionListener(this);
		
		panelFeedback = new JPanel();
		panelFeedback.setForeground(Color.BLACK);
		panelFeedback.setBounds(10, 242, 339, 37);
		frame.getContentPane().add(panelFeedback);
		
		labelFeedback = new JLabel("");
		labelFeedback.setForeground(Color.BLUE);
		labelFeedback.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		panelFeedback.add(labelFeedback);
		
		lblBattlelogSuas = new JLabel("Battlelog : Suas a\u00E7\u00F5es");
		lblBattlelogSuas.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblBattlelogSuas.setBounds(109, 217, 133, 22);
		frame.getContentPane().add(lblBattlelogSuas);
		
		panelFeedback2 = new JPanel();
		panelFeedback2.setBounds(459, 242, 339, 37);
		frame.getContentPane().add(panelFeedback2);
		
		labelFeedback2 = new JLabel("");
		labelFeedback2.setForeground(Color.RED);
		labelFeedback2.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		panelFeedback2.add(labelFeedback2);
		
		lblBattlelogAes = new JLabel("Battlelog : A\u00E7\u00F5es do Computador");
		lblBattlelogAes.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblBattlelogAes.setBounds(529, 217, 201, 22);
		frame.getContentPane().add(lblBattlelogAes);
		
		tratarBtn();
		
		carregaImg();
	}
	
	private JButton criaBtn(JPanel panel,int x,int y,int w,int h, String texto){
		JButton btn = new JButton(texto);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn.setBounds(x, y, w, h);
		panel.add(btn);
		return btn;
	}
	
	private ImageIcon getImage(String url) {
		ImageIcon imgPersonagem = new ImageIcon(InterfaceJogo.class.getResource(url));
		return imgPersonagem;
	}
	
	private void carregaImg(){
		String url = "";
		ImageIcon img;
		JLabel foto;
		ControlarPersonagem ctrlp = new ControlarPersonagem();
		for(int i = 0;i<3;i++){
			url = ctrlp.retornaUrl(usuEqp.get(i)); 
			img = getImage(url);
			foto = retornaLabelChar(i);
			foto.setIcon(img);
		}
		for(int i = 0;i<3;i++){
			url = ctrlp.retornaUrl(maqEqp.get(i));
			img = getImage(url);
			foto = retornaLabelMaq(i);
			foto.setIcon(img);
		}
	}
	
	private JLabel retornaLabelChar(int index){
		switch (index) {
		case 0:
			return foto1;
		case 1:
			return foto2;
		case 2:
			return foto3;
		default:
			return null;
		}
	}
	
	private JLabel retornaLabelMaq(int index){
		switch (index) {
		case 0:
			return fotoMaq1;
		case 1:
			return fotoMaq2;
		case 2:
			return fotoMaq3;
		default:
			return null;
		}
	}
	
	private void organizarEqp(){
		maqEqp = cp.getMaqEquipe();
		usuEqp = cp.getUsuqEquipe();
	}
	
	
	private void tratarBtn(){
		if(!cp.verificarTipo(usuEqp.get(0))){
			btnRestaurar1.setEnabled(false);
		}else{
			btnRestaurar1.setEnabled(true);
		}
		if(!cp.verificarTipo(usuEqp.get(1))){
			btnRestaurar2.setEnabled(false);
		}else{
			btnRestaurar2.setEnabled(true);
		}
		if(!cp.verificarTipo(usuEqp.get(2))){
			btnRestaurar3.setEnabled(false);
		}else{
			btnRestaurar3.setEnabled(true);
		}
		btnReceberVida1.setEnabled(false);
		btnReceberVida2.setEnabled(false);
		btnReceberVida3.setEnabled(false);
	}
	
	private void tratarBtnMaq(){
		btnSelecionar1.setEnabled(false);
		btnSelecionar2.setEnabled(false);
		btnSelecionar3.setEnabled(false);
	}
	
	
	
	private void preencherLife(JProgressBar hp, Personagem personagem){
		hp.setMaximum((int) personagem.getVida());
		hp.setValue((int) personagem.getVidaParcial());
		hp.setString(String.valueOf(personagem.getVidaParcial()+"/"+personagem.getVida()));
	}
	
	private JProgressBar retornaBarMaq(int index){
		if(index == 0){
			return hpMaq1;
		}else if(index == 1){
			return hpMaq2;
		}else if(index == 2){
			return hpMaq3;
		}
		return null;
	}
	
	private JProgressBar retornaBarUsu(int index){
		if(index == 0){
			return hp1;
		}else if(index == 1){
			return hp2;
		}else if(index == 2){
			return hp3;
		}
		return null;
	}
	
	private void atualizaLife(){
		hpMaq1.setMaximum((int)maqEqp.get(0).getVida());
		hpMaq1.setValue((int) maqEqp.get(0).getVidaParcial());
		hpMaq1.setString(String.valueOf(maqEqp.get(0).getVidaParcial()+"/"+maqEqp.get(0).getVida()));
		
		hpMaq2.setMaximum((int)maqEqp.get(1).getVida());
		hpMaq2.setValue((int) maqEqp.get(1).getVidaParcial());
		hpMaq2.setString(String.valueOf(maqEqp.get(1).getVidaParcial()+"/"+maqEqp.get(1).getVida()));
		
		hpMaq3.setMaximum((int)maqEqp.get(2).getVida());
		hpMaq3.setValue((int) maqEqp.get(2).getVidaParcial());
		hpMaq3.setString(String.valueOf(maqEqp.get(2).getVidaParcial()+"/"+maqEqp.get(2).getVida()));
		
		hp1.setMaximum((int)usuEqp.get(0).getVida());
		hp1.setValue((int) usuEqp.get(0).getVidaParcial());
		hp1.setString(String.valueOf(usuEqp.get(0).getVidaParcial()+"/"+usuEqp.get(0).getVida()));	
		
		hp2.setMaximum((int)usuEqp.get(1).getVida());
		hp2.setValue((int) usuEqp.get(1).getVidaParcial());
		hp2.setString(String.valueOf(usuEqp.get(1).getVidaParcial()+"/"+usuEqp.get(1).getVida()));
		
		hp3.setMaximum((int)usuEqp.get(2).getVida());
		hp3.setValue((int) usuEqp.get(2).getVidaParcial());
		hp3.setString(String.valueOf(usuEqp.get(2).getVidaParcial()+"/"+usuEqp.get(2).getVida()));
	}
	
	
	private void incrementaLife(JProgressBar hp, int recebe){
		hp.setMaximum((int) usuEqp.get(recebe).getVida());
		hp.setValue((int) usuEqp.get(recebe).getVidaParcial());
		hp.setString(String.valueOf(usuEqp.get(recebe).getVidaParcial()+"/"+usuEqp.get(recebe).getVida()));
	}
	
	private void habilitarBtn(JButton btnClicado,JButton btn1, JButton btn2){
		btnClicado.setEnabled(false);
		btn1.setEnabled(true);
		btn2.setEnabled(true);
	}
		
	private void acaoAtacar(int atacando, int atacado){
		int reducao;
		reducao = cp.atacar(atacando, atacado);
		labelFeedback.setText(maqEqp.get(atacado).sofrerDano(reducao));
	}
	
	private void verificaVida(int atacado){
		if(maqEqp.get(atacado).getVidaParcial()<=0){
			panelEqpMaq.remove(retornapanel(atacado));
			int tamanho = cp.getTamanho();
			cp.setMortos(atacado);
		}
	}
	
	private JPanel retornapanel(int index){
		if(index == 0){
			return panelMaqBtn1;
		}else if(index == 1){
			return panelMaqBtn2;
		}else if(index == 2){
			return panelMaqBtn3;
		}else{
			return null;
		}
	}
	
	
	private void atacarMaquina(){
		labelFeedback2.setText(cp.atacarMaq());
		atualizaLife();
	}
	
	private void habilitaAtaque(){
		btnSelecionar1.setEnabled(true);
		btnSelecionar2.setEnabled(true);
		btnSelecionar3.setEnabled(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent action) {
		String btnName = action.getActionCommand();
		switch (btnName) {
		case "Atacar 1":
			habilitaAtaque();
			break;
		case "Atacar 2":
			habilitaAtaque();
			break;
		case "Atacar 3":
			habilitaAtaque();
			break;
		case "Restaurar 1":
			habilitarBtn(btnRestaurar1,btnReceberVida2, btnReceberVida3);
			index = 0;
			break;
		case "Restaurar 2":
			habilitarBtn(btnRestaurar2, btnReceberVida1, btnReceberVida3);
			index = 1;
			break;
		case "Restaurar 3":
			habilitarBtn(btnRestaurar3, btnReceberVida1, btnReceberVida2);
			index = 2;
			break;
		case "Receber Vida 2":
			labelFeedback.setText(cp.restaurarVida(usuEqp.get(index), usuEqp.get(1)));
			atualizaLife();
			tratarBtn();
			atacarMaquina();
			break;
		case "Receber Vida 1":
			labelFeedback.setText(cp.restaurarVida(usuEqp.get(index), usuEqp.get(0)));
			atualizaLife();
			tratarBtn();
			atacarMaquina();
			break;
		case "Receber Vida 3":
			labelFeedback.setText(cp.restaurarVida(usuEqp.get(index), usuEqp.get(2)));
			atualizaLife();
			tratarBtn();
			atacarMaquina();
			break;
		case "Selecionar 1":
			acaoAtacar(indexAtaque, 0);
			atualizaLife();
			verificaVida(0);
			atacarMaquina();
			tratarBtnMaq();
			break;
		case "Selecionar 2":
			acaoAtacar(indexAtaque, 1);
			atualizaLife();
			verificaVida(1);
			atacarMaquina();
			tratarBtnMaq();
			break;
		case "Selecionar 3":
			acaoAtacar(indexAtaque, 2);
			atualizaLife();
			verificaVida(2);
			atacarMaquina();
			tratarBtnMaq();
			break;
		default:
			break;
		}
		
	}
}
