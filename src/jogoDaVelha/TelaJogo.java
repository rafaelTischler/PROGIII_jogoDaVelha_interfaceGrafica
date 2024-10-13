package jogoDaVelha;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaJogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("");
	private final JLabel lblNewLabel_4 = new JLabel("");
	private final JLabel lblNewLabel_5 = new JLabel("");
	private final JLabel lblNewLabel_6 = new JLabel("");
	private final JLabel lblNewLabel_7 = new JLabel("");
	private final JLabel lblNewLabel_8 = new JLabel("");
	private final JLabel lblNewLabel_9 = new JLabel("");
	private final JLabel lblNewLabel_10 = new JLabel("");
	private final JLabel lblJogador = new JLabel("Jogador: ");
	private final JLabel lblNewLabel = new JLabel("Computador: ");
	private final JButton btnNewButton = new JButton("Desfazer");
	// private LinkedList<JLabel> listaBotoes = new LinkedList<JLabel>();

	public TelaJogo() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[50px][grow][grow][50px]", "[50px][][grow][][50px]"));
		setBounds(100, 100, 800, 600);
		add(this.lblJogador, "cell 1 1,growx");
		this.lblJogador.setOpaque(true);
		add(this.lblNewLabel, "cell 2 1,growx");
		this.lblNewLabel.setOpaque(true);
		add(this.panel, "cell 1 2 2 1,grow");
		this.panel.setLayout(new MigLayout("", "[25px][100px][100px][100px][25px]", "[25px][100px][100px][100px][25px]"));
		this.lblNewLabel_2.setRequestFocusEnabled(false);
		this.lblNewLabel_2.setOpaque(true);
		this.lblNewLabel_2.setBackground(Color.GRAY);
		this.panel.add(this.lblNewLabel_2, "cell 1 1,grow");
		this.lblNewLabel_3.setRequestFocusEnabled(false);
		this.lblNewLabel_3.setBackground(Color.GRAY);
		this.lblNewLabel_3.setOpaque(true);
		this.panel.add(this.lblNewLabel_3, "cell 2 1,grow");
		this.lblNewLabel_4.setRequestFocusEnabled(false);
		this.lblNewLabel_4.setBackground(Color.GRAY);
		this.lblNewLabel_4.setOpaque(true);
		this.panel.add(this.lblNewLabel_4, "cell 3 1,grow");
		this.lblNewLabel_5.setRequestFocusEnabled(false);
		this.lblNewLabel_5.setBackground(Color.GRAY);
		this.lblNewLabel_5.setOpaque(true);
		this.panel.add(this.lblNewLabel_5, "cell 1 2,grow");
		this.lblNewLabel_6.setRequestFocusEnabled(false);
		this.lblNewLabel_6.setBackground(Color.GRAY);
		this.lblNewLabel_6.setOpaque(true);
		this.panel.add(this.lblNewLabel_6, "cell 2 2,grow");
		this.lblNewLabel_7.setRequestFocusEnabled(false);
		this.lblNewLabel_7.setBackground(Color.GRAY);
		this.lblNewLabel_7.setOpaque(true);
		this.panel.add(this.lblNewLabel_7, "cell 3 2,grow");
		this.lblNewLabel_8.setRequestFocusEnabled(false);
		this.lblNewLabel_8.setBackground(Color.GRAY);
		this.lblNewLabel_8.setOpaque(true);
		this.panel.add(this.lblNewLabel_8, "cell 1 3,grow");
		this.lblNewLabel_9.setRequestFocusEnabled(false);
		this.lblNewLabel_9.setBackground(Color.GRAY);
		this.lblNewLabel_9.setOpaque(true);
		this.panel.add(this.lblNewLabel_9, "cell 2 3,grow");
		this.lblNewLabel_10.setRequestFocusEnabled(false);
		this.lblNewLabel_10.setBackground(Color.GRAY);
		this.lblNewLabel_10.setOpaque(true);
		this.panel.add(this.lblNewLabel_10, "cell 3 3,grow");
		this.panel.add(this.btnNewButton, "cell 2 4,alignx center");
		this.btnNewButton.setOpaque(false);
	}

}
