package jogoDaVelha;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Dimension;

public class TelaInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lbl_jogo = new JLabel("JOGO DA");
	private final JLabel lbl_velha = new JLabel("VELHA");
	private final JButton btn_jogar = new JButton("JOGAR");
	private final JButton btn_sair = new JButton("SAIR");
	private Image background;

	public TelaInicial() {
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

	private void initComponents() {
		setBounds(100, 100, 800, 600);
		setBackground(new Color(234, 228, 221));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		this.panel.setOpaque(false);
		this.panel.setBackground(new Color(205, 194, 165));

		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow][][grow][][grow]"));
		this.lbl_jogo.setForeground(Color.WHITE);
		this.lbl_jogo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 60));

		this.panel.add(this.lbl_jogo, "flowy,cell 1 1,alignx center,aligny bottom");
		this.btn_jogar.setMargin(new Insets(2, 10, 2, 10));
		this.btn_jogar.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.btn_jogar.setOpaque(false);
		this.btn_jogar.setForeground(Color.DARK_GRAY);
		this.btn_jogar.setFocusPainted(false);
		this.btn_jogar.setFocusTraversalKeysEnabled(false);
		this.btn_jogar.setFocusable(false);
		this.btn_jogar.setRequestFocusEnabled(false);
		this.btn_jogar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btn_jogar.setPreferredSize(new java.awt.Dimension(150, 40));
		this.btn_jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abreTelaMenu();
			}
		});
		this.btn_jogar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));

		this.panel.add(this.btn_jogar, "cell 1 3,alignx center,aligny center");
		this.btn_sair.setContentAreaFilled(false);
		this.btn_sair.setMinimumSize(new Dimension(45, 20));
		this.btn_sair.setMaximumSize(new Dimension(50, 25));
		this.btn_sair.setMargin(new Insets(2, 5, 2, 5));
		this.btn_sair.setForeground(Color.DARK_GRAY);
		this.btn_sair.setRequestFocusEnabled(false);
		this.btn_sair.setOpaque(false);
		this.btn_sair.setFocusPainted(false);
		this.btn_sair.setFocusTraversalKeysEnabled(false);
		this.btn_sair.setFocusable(false);
		this.btn_sair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btn_sair.setBackground(new Color(240, 240, 240));
		this.btn_sair.setPreferredSize(new java.awt.Dimension(150, 40));
		this.btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime.getRuntime().exit(0);
			}
		});
		this.btn_sair.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		this.panel.add(this.btn_sair, "cell 1 5,alignx center,aligny center");
		this.lbl_velha.setForeground(Color.WHITE);
		this.lbl_velha.setFont(new Font("Segoe UI Black", Font.PLAIN, 90));

		this.panel.add(this.lbl_velha, "cell 1 1,alignx center,aligny top");

		efeitoMouseOver();
	}

	private void efeitoMouseOver() {
		btn_jogar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evento) {
				btn_jogar.setForeground(new Color(41, 95, 152));
			}

			public void mouseExited(java.awt.event.MouseEvent evento) {
				btn_jogar.setForeground(Color.DARK_GRAY);
			}
		});
		btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evento) {
				btn_sair.setForeground(Color.RED);
			}

			public void mouseExited(java.awt.event.MouseEvent evento) {
				btn_sair.setForeground(Color.DARK_GRAY);
			}
		});
	}

	protected void abreTelaMenu() {
		Janela.frame.setContentPane(new TelaMenu());
		Janela.frame.setVisible(true);

	}

}
