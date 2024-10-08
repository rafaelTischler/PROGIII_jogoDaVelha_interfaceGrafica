package jogoDaVelha;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel lblNewLabel_1 = new JLabel("Nome do jogador:");
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Simbolo:");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JCheckBox chckbxNewCheckBox = new JCheckBox("X");
	private final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("O");
	private final JButton btnNewButton = new JButton("Jogar");

	public TelaInicial() {
		this.textField.setColumns(10);
		initComponents();

	}

	public void initComponents() {
		this.setBounds(100, 100, 500, 500);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));

		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[][][][]", "[][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Jogo da Velha");
		panel.add(lblNewLabel, "cell 1 1");
		panel.add(this.lblNewLabel_1, "cell 1 3,alignx trailing");
		panel.add(this.textField, "cell 2 3,growx");
		panel.add(this.lblNewLabel_2, "cell 1 4");
		this.buttonGroup.add(this.chckbxNewCheckBox);
		panel.add(this.chckbxNewCheckBox, "flowx,cell 2 4");
		this.buttonGroup.add(this.chckbxNewCheckBox_1);
		panel.add(this.chckbxNewCheckBox_1, "cell 2 4");
		this.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaJogo();
			}
		});
		panel.add(this.btnNewButton, "cell 2 5,alignx right");
	}

	protected void abrirTelaJogo() {
		Janela.frame.setContentPane(new TelaJogo());
		Janela.frame.setVisible(true);
	}

}
