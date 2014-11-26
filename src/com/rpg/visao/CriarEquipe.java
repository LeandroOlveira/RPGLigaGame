package com.rpg.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTable;

import javax.swing.JComboBox;

import com.rpg.controle.ControlarEquipe;
import com.rpg.enums.Nomes;

import java.awt.Rectangle;

public class CriarEquipe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panelComboBox;
	private JPanel panelFoto;
	private JLabel lblFoto;
	private JPanel panelBtn;
	private JButton btnAdicionar;
	private JTable table;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private List<Nomes> nomeChar = new ArrayList<Nomes>();
	private Nomes name;
	private String[] listaHerois = { "Aquaman", "Batman", "Coringa", "Flash",
			"Giganta", "Lanterna Verde", "Lex Luthor", "Lobo",
			"Mulher Maravilha", "Sinestro", "Superman", "Volcana" };
	private int contaChar = 0;
	private JPanel panelTbl;
	private JLabel lblSuaEquipe;
	private JPanel btnControle;
	private JButton btnExcluir;
	private JButton btnIniciar;
	private ImageIcon heroiImg = new ImageIcon();

	public CriarEquipe() {
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame("Selecionar Personagens");
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 800, 550);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		panelComboBox = new JPanel();
		panelComboBox.setBounds(0, 0, 130, 521);
		frame.getContentPane().add(panelComboBox);
		panelComboBox.setLayout(null);

		criarCombox();

		panelFoto = new JPanel();
		panelFoto.setBounds(158, 53, 300, 400);
		frame.getContentPane().add(panelFoto);

		lblFoto = new JLabel("");
		panelFoto.add(lblFoto);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(158, 21, 300, 31);
		frame.getContentPane().add(panelTitulo);

		JLabel lblTitulo = new JLabel("Personagem");
		lblTitulo.setForeground(Color.RED);
		lblTitulo.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		panelTitulo.add(lblTitulo);

		panelBtn = new JPanel();
		panelBtn.setBounds(158, 459, 300, 38);
		frame.getContentPane().add(panelBtn);
		panelBtn.setLayout(null);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(0, 0, 300, 38);
		panelBtn.add(btnAdicionar);
		btnAdicionar.setEnabled(true);
		btnAdicionar.addActionListener(this);

		panelTbl = new JPanel();
		panelTbl.setBounds(506, 54, 211, 188);
		frame.getContentPane().add(panelTbl);

		btnControle = new JPanel();
		btnControle.setBounds(506, 253, 211, 111);
		frame.getContentPane().add(btnControle);
		btnControle.setLayout(null);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(38, 11, 134, 32);
		btnControle.add(btnExcluir);
		btnExcluir.addActionListener(this);

		btnIniciar = new JButton("Iniciar Partida");
		btnIniciar.setBounds(38, 54, 134, 32);
		btnControle.add(btnIniciar);
		btnIniciar.addActionListener(this);

		getTable();
		tratarBotoes();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void criarCombox() {
		comboBox = new JComboBox(listaHerois);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(this);
		comboBox.setBounds(10, 58, 110, 33);
		panelComboBox.add(comboBox);
	}

	private void getTable() {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		Border linha = BorderFactory.createLineBorder(Color.black);
		panelTbl.setLayout(null);
		table = new JTable(3, 1);
		table.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		panelTbl.add(table);
		table.setBounds(new Rectangle(37, 68, 133, 120));
		table.setName("Sua Equipe");
		table.setRowHeight(40);
		table.setBorder(linha);

		lblSuaEquipe = new JLabel("Sua Equipe");
		lblSuaEquipe.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		lblSuaEquipe.setForeground(Color.BLACK);
		lblSuaEquipe.setBounds(55, 34, 91, 22);
		panelTbl.add(lblSuaEquipe);
		table.setVisible(false);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
	}

	private ImageIcon getImage(String url) {
		ImageIcon imgPersonagem = new ImageIcon(
				CriarEquipe.class.getResource(url));
		return imgPersonagem;
	}

	private void tratarBotoes() {
		if (comboBox.getSelectedIndex() == -1) {
			btnAdicionar.setEnabled(false);
		} else {
			btnAdicionar.setEnabled(true);
		}
		if (nomeChar.isEmpty()) {
			btnExcluir.setEnabled(false);
			btnIniciar.setEnabled(false);
		} else {
			btnExcluir.setEnabled(true);
		}
		if (contaChar >= 3) {
			btnAdicionar.setEnabled(false);
			btnIniciar.setEnabled(true);
		} else {
			btnIniciar.setEnabled(false);
		}
	}

	private void setarImagem(String url) {
		heroiImg = getImage(url);
		lblFoto.setIcon(heroiImg);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String btnName = action.getActionCommand();
		String url;
		String nome;

		switch (btnName) {
		case "Adicionar":
			nomeChar.add(name);
			table.setEnabled(false);
			table.setVisible(true);
			table.setValueAt(name.toString(name), contaChar, 0);
			contaChar++;
			tratarBotoes();
			break;
		case "Excluir":
			nomeChar.remove(--contaChar);
			table.setValueAt("", contaChar, 0);
			System.out.println(nomeChar);
			tratarBotoes();
			break;
		case "Iniciar Partida":
			ControlarEquipe ctrlE = new ControlarEquipe();
			ctrlE.criarEquipe(nomeChar);
			new Batalha();
			frame.setEnabled(false);
			frame.setVisible(false);
			break;
		}
		nome = (String) comboBox.getSelectedItem();
		switch (nome) {
		case "Aquaman":
			name = Nomes.AQUAMAN;
			url = "/AquamanEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Batman":
			name = Nomes.BATMAN;
			url = "/batmanEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Coringa":
			name = Nomes.CORINGA;
			url = "/coringaEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Flash":
			name = Nomes.FLASH;
			url = "/flashEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Giganta":
			name = Nomes.GIGANTA;
			url = "/gigantaEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Lanterna Verde":
			name = Nomes.LANTERNAVERDE;
			url = "/lanternaEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Lex Luthor":
			name = Nomes.LEXLUTHOR;
			url = "/lexEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Lobo":
			name = Nomes.LOBO;
			url = "/loboEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Mulher Maravilha":
			name = Nomes.MULHERMARAVILHA;
			url = "/mulherEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Sinestro":
			name = Nomes.SINESTRO;
			url = "/sinestroEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Superman":
			name = Nomes.SUPERMAN;
			url = "/supermanEditado.jpg";
			setarImagem(url);
			tratarBotoes();
			break;
		case "Volcana":
			url = "/volcanaEditado.jpg";
			setarImagem(url);
			name = Nomes.VOLCANA;
			tratarBotoes();
		default:
			break;
		}
	}
}
