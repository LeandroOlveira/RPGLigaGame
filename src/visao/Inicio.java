package visao;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controle.ControlarEquipe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;




public class Inicio extends JFrame implements ActionListener{ 

	private static final int TAMANHO_HORIZONTAL = 800;
	private static final int TAMANHO_VETICAL = 510;
	private ImageIcon imagemInicio = new ImageIcon();
	private JPanel contentPane;
	private JButton btnEquipesAleatrias;
	private static final int USUARIO = 1;
	private static final int MAQUINA = 2;

	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Inicio frame = new Inicio();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
}
	


	
	public Inicio(){
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,800,511);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
			JPanel panel1 = new JPanel();
			panel1.setBounds(0, 11, TAMANHO_HORIZONTAL, TAMANHO_VETICAL);
			contentPane.add(panel1);
			panel1.setLayout(null);
			JPanel panel = new JPanel();
			panel.setBounds(0, 73, 790, 388);
			panel1.add(panel);
			
			JLabel label = new JLabel("");
			panel.add(label);
			imagemInicio = getImage("/images/inicio.jpg");
			label.setIcon(imagemInicio);
			
			JButton btnEscolherEqp = new JButton("Escolher Equipes");
			btnEscolherEqp.setBounds(10, 11, 145, 51);
			panel1.add(btnEscolherEqp);
			btnEscolherEqp.addActionListener(this);			
			
			btnEquipesAleatrias = new JButton("Equipes Aleat\u00F3rias");
			btnEquipesAleatrias.setBounds(175, 11, 145, 51);
			panel1.add(btnEquipesAleatrias);
			btnEquipesAleatrias.addActionListener(this);
			
			
		
	}
	private ImageIcon getImage(String url) {
		ImageIcon im = new  ImageIcon(Inicio.class.getResource(url));
		return im;
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String btnName = action.getActionCommand();
		switch (btnName) {
		case "Escolher Equipes":
			new CriarEquipe();
			this.setVisible(false);
			this.setEnabled(false);
			break;
		case "Equipes Aleat\u00F3rias":
			ControlarEquipe ce = new ControlarEquipe();
			ce.criarAleatorias(MAQUINA);
			ce.criarAleatorias(USUARIO);
			new InterfaceJogo();
			this.setEnabled(false);
			this.setVisible(false);
			break;
			
		}
	}
}

