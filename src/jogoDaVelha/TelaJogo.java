package jogoDaVelha;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

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
	private Image background;

	public TelaJogo() {
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!java.beans.Beans.isDesignTime() && background != null) {
			g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		}
	}

	private void initComponents() {
		setBackground(new Color(245, 239, 231));
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		setBounds(100, 100, 800, 600);
		painel.setOpaque(false);
		add(painel, "cell 1 1,grow");
		painel.setLayout(new MigLayout("", "[120px,grow][120px,grow][120px,grow]", "[120px,grow][120px,grow][120px,grow]"));
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
}
