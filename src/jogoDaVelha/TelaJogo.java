package jogoDaVelha;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TelaJogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private final JLabel lbl_11 = new JLabel("");
	private final JLabel lbl_12 = new JLabel("");
	private final JLabel lbl_13 = new JLabel("");
	private final JLabel lbl_21 = new JLabel("");
	private final JLabel lbl_22 = new JLabel("");
	private final JLabel lbl_23 = new JLabel("");
	private final JLabel lbl_31 = new JLabel("");
	private final JLabel lbl_32 = new JLabel("");
	private final JLabel lbl_33 = new JLabel("");
	private final JButton btn_desfazer = new JButton("");
	private final JButton btn_menu = new JButton("MENU");
	private ImageIcon O = new ImageIcon(getClass().getResource("/jogoDaVelha/O.png"));
	private ImageIcon X = new ImageIcon(getClass().getResource("/jogoDaVelha/X.png"));
	protected LinkedList<JLabel> lista = new LinkedList<JLabel>();
	protected Stack<Tabuleiro> tabPilha = new Stack<Tabuleiro>();
	protected Stack<Integer> intPilha = new Stack<Integer>();
	private Image background;
	private Tabuleiro tab = new Tabuleiro();
	private Jogador jogador;
	private Jogador pc;

	public TelaJogo(Jogador jogador, Jogador pc, Tabuleiro tab) {
		this.jogador = jogador;
		this.pc = pc;
		this.tab = tab;
		if (!java.beans.Beans.isDesignTime()) {
			try {
				background = ImageIO.read(getClass().getResource("background_clear.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			painel = new PainelTabela("/jogoDaVelha/asset_table2.png");
		} else {
			painel = new JPanel();
		}
		initComponents();
		jogada();
		tab.imprimeTabuleiro();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!java.beans.Beans.isDesignTime() && background != null) {
			g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		}
	}

	private void initComponents() {
		setBackground(new Color(216, 196, 182));
		setLayout(new MigLayout("", "[200,grow][][200,grow]", "[::100px,grow][][::100px,grow]"));
		setBounds(100, 100, 800, 600);
		this.btn_desfazer.setRequestFocusEnabled(false);
		this.btn_desfazer.setFocusable(false);
		this.btn_desfazer.setFocusPainted(false);
		this.btn_desfazer.setFocusTraversalKeysEnabled(false);
		this.btn_desfazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("*Jogada DESFEITA*");
				desfazerJogada();
			}
		});
		this.btn_desfazer.setContentAreaFilled(false);
		this.btn_desfazer.setOpaque(false);
		add(this.btn_desfazer, "cell 0 0,alignx right,aligny center");
		this.btn_desfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoDaVelha/undo_arrow.png")));
		painel.setOpaque(false);
		add(painel, "cell 1 1,grow");
		painel.setLayout(new MigLayout("", "[120px,grow,center][120px,grow,center][120px,grow,center]",
				"[120px,grow,center][120px,grow,center][120px,grow,center]"));
		lbl_11.setName("1,1");
		painel.add(lbl_11, "cell 0 0,grow");
		lbl_12.setName("1,2");
		painel.add(lbl_12, "cell 1 0,grow");
		lbl_13.setName("1,3");
		painel.add(lbl_13, "cell 2 0,grow");
		lbl_21.setName("2,1");
		painel.add(lbl_21, "cell 0 1,grow");
		lbl_22.setName("2,2");
		painel.add(lbl_22, "cell 1 1,grow");
		lbl_23.setName("2,3");
		painel.add(lbl_23, "cell 2 1,grow");
		lbl_31.setName("3,1");
		painel.add(lbl_31, "cell 0 2,grow");
		lbl_32.setName("3,2");
		painel.add(lbl_32, "cell 1 2,grow");
		lbl_33.setName("3,3");
		painel.add(lbl_33, "cell 2 2,grow");
		lista.add(lbl_11);
		lista.add(lbl_12);
		lista.add(lbl_13);
		lista.add(lbl_21);
		lista.add(lbl_22);
		lista.add(lbl_23);
		lista.add(lbl_31);
		lista.add(lbl_32);
		lista.add(lbl_33);
		efeitoMouseOver();
		this.btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaMenu();
			}
		});
		this.btn_menu.setContentAreaFilled(false);
		this.btn_menu.setForeground(new Color(79, 112, 156));
		this.btn_menu.setRequestFocusEnabled(false);
		this.btn_menu.setOpaque(false);
		this.btn_menu.setFocusPainted(false);
		this.btn_menu.setFocusTraversalKeysEnabled(false);
		this.btn_menu.setFocusable(false);
		this.btn_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btn_menu.setBackground(new Color(240, 240, 240));
		this.btn_menu.setFont(new Font("Segoe UI", Font.BOLD, 24));
		add(this.btn_menu, "cell 2 0,alignx left,aligny center");
	}

	protected void abrirTelaMenu() {
		Janela.frame.setContentPane(new TelaMenu());
		Janela.frame.setVisible(true);
	}

	private void efeitoMouseOver() {
		btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evento) {
				btn_menu.setForeground(new Color(145, 168, 200));
			}

			public void mouseExited(java.awt.event.MouseEvent evento) {
				btn_menu.setForeground(new Color(79, 112, 156));
			}
		});
		btn_desfazer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evento) {
				btn_desfazer.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/jogoDaVelha/undo_arrow_focus.png")));
			}

			public void mouseExited(java.awt.event.MouseEvent evento) {
				btn_desfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoDaVelha/undo_arrow.png")));
			}
		});
	}

	public class PainelTabela extends JPanel {
		private static final long serialVersionUID = 1L;
		private Image backgroundImage;

		public PainelTabela(String imagePath) {
			if (!java.beans.Beans.isDesignTime()) {
				try {
					backgroundImage = ImageIO.read(getClass().getResource(imagePath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (!java.beans.Beans.isDesignTime() && backgroundImage != null) {
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}

	private void jogada() {
		for (JLabel label : lista) {
			label.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jogar();
				}
			});
		}
	}

	private void jogar() {
		for (JLabel label : lista) {
			if ((label.getMousePosition(false) != null) && !tab.verificaVencedor() && !tab.verificaEmpate()) {
				String[] vetorLabel = label.getName().split(",");
				int linha = Integer.parseInt(vetorLabel[0]) - 1;
				int coluna = Integer.parseInt(vetorLabel[1]) - 1;
				if (tab.verificaPosicao(linha, coluna)) {
					jogador.fazerJogada(linha, coluna, jogador);
					if (jogador.getSimbolo().equals("X")) {
						label.setIcon(X);
					} else if (jogador.getSimbolo().equals("O")) {
						label.setIcon(O);
					}
					tabPilha.push(new Tabuleiro(tab));
					intPilha.push(linha);
					intPilha.push(coluna);
					if (!tab.verificaVencedor() && !tab.verificaEmpate()) {
						jogarcomputador();
					} else {
						if (tab.verificaEmpate()) {
							System.out.println("Empate!");
							JOptionPane.showMessageDialog(this, "Empate!");
							reiniciarJogo();
						} else if (tab.getVencedor().equals("[" + jogador.getSimbolo() + "]")) {
							System.out.println("Vencedor: " + jogador.getNome());
							JOptionPane.showMessageDialog(this, "Vencedor: " + jogador.getNome());
							reiniciarJogo();
						} else if (tab.getVencedor().equals("[" + pc.getSimbolo() + "]")) {
							System.out.println("Vencedor: " + pc.getNome());
							JOptionPane.showMessageDialog(this, "Vencedor: " + pc.getNome());
							reiniciarJogo();
						}
					}
				}
			}
		}
	}

	private void jogarcomputador() {
		int linha, coluna;
		do {
			linha = tab.gerarNumAleatorio();
			coluna = tab.gerarNumAleatorio();
		} while (!tab.verificaPosicao(linha, coluna));
		tab.realizaJogada(linha, coluna, pc);
		String celula = "";
		celula += (linha + 1) + ",";
		celula += (coluna + 1);
		for (JLabel labelPc : lista) {
			if (celula.equals(labelPc.getName())) {
				if (pc.getSimbolo().equals("X")) {
					labelPc.setIcon(X);
				} else if (pc.getSimbolo().equals("O")) {
					labelPc.setIcon(O);
				}
				tabPilha.push(new Tabuleiro(tab));
				intPilha.push(linha);
				intPilha.push(coluna);
				tab.imprimeTabuleiro();
				if (tab.verificaVencedor()) {
					if (tab.getVencedor().equals("[X]")) {
						System.out.println("Vencedor: " + jogador.getNome());
						JOptionPane.showMessageDialog(this, "Vencedor: " + jogador.getNome());
					} else {
						if (tab.getVencedor().equals("[O]")) {
							System.out.println("Vencedor: " + pc.getNome());
							JOptionPane.showMessageDialog(this, "Vencedor: " + pc.getNome());
						}
					}
				}
			}
		}
	}

	private void desfazerJogada() {
		if ((intPilha.size() >= 4 && !tab.verificaVencedor())) {
			int coluna = intPilha.pop();
			int linha = intPilha.pop();
			tab.realizaJogada(linha, coluna, null);
			String celula = (linha + 1) + "," + (coluna + 1);
			for (JLabel label : lista) {
				if (celula.equals(label.getName())) {
					label.setIcon(null);
				}
			}
			if (!intPilha.isEmpty()) {
				coluna = intPilha.pop();
				linha = intPilha.pop();
				tab.realizaJogada(linha, coluna, null);
				celula = (linha + 1) + "," + (coluna + 1);
				for (JLabel label : lista) {
					if (celula.equals(label.getName())) {
						label.setIcon(null);
					}
				}
			}
			tab.imprimeTabuleiro();
		}
	}

	private void reiniciarJogo() {
		int response = JOptionPane.showConfirmDialog(this, "Você gostaria de iniciar um novo jogo?", "Novo Jogo",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			abrirTelaMenu();
			for (JLabel label : lista) {
				label.setIcon(null);
			}
		}
	}
}
