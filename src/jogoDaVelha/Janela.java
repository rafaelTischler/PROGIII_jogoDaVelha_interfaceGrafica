package jogoDaVelha;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	static Janela frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("              Instituto Federal Farroupilha - Campus São Vicente do Sul");
		System.out.println("                Tecnologia em Análise e Desenvolvimento de Sistemas");
		System.out.println("Disciplina: Programação III     Professor: Gustavo Rissetti       Data: 20/10/2024");
		System.out.println("Aluno: Rafael Müller Tischler                                        Turma: ADS 19");
		System.out.println("\n             TRABALHO PRÁTICO 2 - JOGO DA VELHA COM INTERFACE GRÁFICA\n");
	}

	public Janela() {
		initComponents();
		this.setContentPane(new TelaInicial());
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
