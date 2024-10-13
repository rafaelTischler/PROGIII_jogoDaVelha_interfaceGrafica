package jogoDaVelha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class TelaMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel lbl_nome = new JLabel("NOME DO JOGADOR");
	private final JTextField edit_nome = new JTextField();
	private final JLabel lbl_simbolo = new JLabel("ESCOLHA SEU SÍMBOLO");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JButton btn_iniciar = new JButton("INICIAR");
	private final JLabel lbl_jogo_1 = new JLabel("VELHA");
	private final JLabel lbl_setaEsq = new JLabel("");
	private final JLabel lbl_setaDir = new JLabel("");
	private Image background;
	private final JButton btn_voltar = new JButton("VOLTAR");
	private final JToggleButton tglbtn_o = new JToggleButton("");
	private final JToggleButton tglbtn_x = new JToggleButton("");

	public TelaMenu() {
		try {
			background = ImageIO.read(getClass().getResource("background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		initComponents();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}

	public void initComponents() {
		this.setBounds(100, 100, 800, 600);
		setBackground(new Color(245, 239, 231));
		setLayout(new MigLayout("", "[grow][center][grow]", "[grow][grow][grow]"));
		this.buttonGroup.add(this.tglbtn_o);
		this.tglbtn_o.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtn_o.isSelected()) {
					try {
						background = ImageIO.read(getClass().getResource("background_o_selected.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					repaint();
				}
			}
		});
		this.tglbtn_o.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!tglbtn_o.isSelected() && !tglbtn_x.isSelected()) {
					try {
						background = ImageIO.read(getClass().getResource("background_o.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!tglbtn_o.isSelected() && !tglbtn_x.isSelected()) {
					try {
						background = ImageIO.read(getClass().getResource("background.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					repaint();
				}
			}
		});
		this.tglbtn_o.setFocusPainted(false);
		this.tglbtn_o.setFocusable(false);
		this.tglbtn_o.setContentAreaFilled(false);
		this.tglbtn_o.setBorder(null);

		add(this.tglbtn_o, "cell 0 1,grow");

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(245, 239, 231));
		add(panel, "cell 1 1,alignx center,growy");
		panel.setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][][grow][][][][][grow][][grow][][grow]"));

		JLabel lbl_jogo = new JLabel("JOGO DA");
		lbl_jogo.setForeground(new Color(115, 145, 185));
		lbl_jogo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		panel.add(lbl_jogo, "cell 2 1,alignx center,aligny center");
		this.lbl_jogo_1.setForeground(new Color(79, 112, 156));
		this.lbl_jogo_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 45));

		panel.add(this.lbl_jogo_1, "cell 2 2,alignx center,aligny center");
		this.lbl_nome.setForeground(new Color(115, 145, 185));
		this.lbl_nome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(this.lbl_nome, "cell 2 4,alignx center,aligny center");

		this.edit_nome.setHorizontalAlignment(SwingConstants.CENTER);
		this.edit_nome.setForeground(new Color(145, 168, 200));
		this.edit_nome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		panel.add(this.edit_nome, "cell 2 5,growx,aligny center");

		panel.add(this.lbl_setaEsq, "cell 0 7,alignx right,aligny center");

		this.lbl_setaEsq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoDaVelha/left_arrow.png")));
		this.lbl_simbolo.setForeground(new Color(115, 145, 185));
		this.lbl_simbolo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(this.lbl_simbolo, "cell 2 7,alignx center,aligny center");
		this.btn_iniciar.setOpaque(false);
		this.btn_iniciar.setRequestFocusEnabled(false);
		this.btn_iniciar.setForeground(new Color(79, 112, 156));
		this.btn_iniciar.setFont(new Font("Segoe UI", Font.BOLD, 22));
		this.btn_iniciar.setFocusable(false);
		this.btn_iniciar.setFocusTraversalKeysEnabled(false);
		this.btn_iniciar.setFocusPainted(false);
		this.btn_iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		this.btn_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!edit_nome.getText().isEmpty()) {
					abrirTelaJogo();
				} else {
					JOptionPane.showMessageDialog(TelaMenu.this, "Por favor, insira o nome do jogador!");
				}
			}
		});

		panel.add(this.lbl_setaDir, "cell 4 7,alignx left,aligny center");
		this.lbl_setaDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoDaVelha/right_arrow.png")));
		panel.add(this.btn_iniciar, "cell 2 9,growx,aligny center");
		this.btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaInicial();
			}
		});
		this.btn_voltar.setMinimumSize(new Dimension(45, 20));
		this.btn_voltar.setMaximumSize(new Dimension(150, 25));
		this.btn_voltar.setContentAreaFilled(false);
		this.btn_voltar.setRequestFocusEnabled(false);
		this.btn_voltar.setForeground(new Color(115, 145, 185));
		this.btn_voltar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		this.btn_voltar.setFocusable(false);
		this.btn_voltar.setFocusTraversalKeysEnabled(false);
		this.btn_voltar.setFocusPainted(false);
		this.btn_voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		panel.add(this.btn_voltar, "cell 2 11,alignx center,aligny center");

		efeitoMouseOver();
		this.buttonGroup.add(this.tglbtn_x);
		this.tglbtn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtn_x.isSelected()) {
					try {
						background = ImageIO.read(getClass().getResource("background_x_selected.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					repaint();
				}
			}
		});
		this.tglbtn_x.setFocusable(false);
		this.tglbtn_x.setFocusPainted(false);
		this.tglbtn_x.setBorder(null);
		this.tglbtn_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!tglbtn_o.isSelected() && !tglbtn_x.isSelected()) {
					try {
						background = ImageIO.read(getClass().getResource("background_x.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!tglbtn_o.isSelected() && !tglbtn_x.isSelected()) {
					try {
						background = ImageIO.read(getClass().getResource("background.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					repaint();
				}
			}
		});
		this.tglbtn_x.setContentAreaFilled(false);

		add(this.tglbtn_x, "cell 2 1,grow");
	}

	private void efeitoMouseOver() {
		btn_iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evento) {
				btn_iniciar.setForeground(new Color(115, 145, 185));
			}

			public void mouseExited(java.awt.event.MouseEvent evento) {
				btn_iniciar.setForeground(new Color(79, 112, 156));
			}
		});
		btn_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evento) {
				btn_voltar.setForeground(new Color(145, 168, 200));
			}

			public void mouseExited(java.awt.event.MouseEvent evento) {
				btn_voltar.setForeground(new Color(115, 145, 185));
			}
		});
	}

	protected void abrirTelaInicial() {
		Janela.frame.setContentPane(new TelaInicial());
		Janela.frame.setVisible(true);

	}

	protected void abrirTelaJogo() {
		Janela.frame.setContentPane(new TelaJogo());
		Janela.frame.setVisible(true);
	}

}
