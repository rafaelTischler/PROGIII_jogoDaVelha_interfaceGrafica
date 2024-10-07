package jogoDaVelha;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	static Janela frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela() {
		initComponents();
		// this.setContentPane(new TelaInicial());
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
	}

}
