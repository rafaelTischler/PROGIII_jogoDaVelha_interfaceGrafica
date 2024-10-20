package jogoDaVelha;

public class Tabuleiro {

	private String[][] tabuleiro;
	private String vencedor;
	private int tentativas;

	public Tabuleiro() {
		tabuleiro = new String[3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = "[ ]";
			}
		}
		tentativas = 0;
		vencedor = null;
	}

	public Tabuleiro(Tabuleiro tab) {
		this();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				this.tabuleiro[i][j] = tab.tabuleiro[i][j];
			}
		}
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public void imprimeTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j]);
			}
			System.out.println("");
		}
	}

	public void realizaJogada(int i, int j, Jogador jogador) {
		if (i < 0 || i >= 3 || j < 0 || j >= 3) {
			System.out.println("\tDigite uma posição VÁLIDA!");
			return;
		}
		if (!"[ ]".equals(tabuleiro[i][j])) {
			if (!jogador.isPc()) {
				System.out.println("\tA posição já está OCUPADA!");
			}
			return;
		}
		tabuleiro[i][j] = "[" + jogador.getSimbolo() + "]";
		System.out.println("Jogador " + jogador.getNome() + " jogou na posição: " + i + ", " + j);
	}

	public boolean verificaPosicao(int l, int c) {
		if (l >= 0 && l < 3 && c >= 0 && c < 3 && tabuleiro[l][c].equals("[ ]")) {
			return true;
		}
		return false;
	}

	public boolean verificaVencedor() {
		for (int i = 0; i <= 2; i++) {
			if (tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][1].equals(tabuleiro[i][2])
					&& !tabuleiro[i][0].equals("[ ]")) {
				vencedor = tabuleiro[i][0];
				return true;
			}
			if (tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[1][i].equals(tabuleiro[2][i])
					&& !tabuleiro[0][i].equals("[ ]")) {
				vencedor = tabuleiro[0][i];
				return true;
			}
		}
		if (tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][2])
				&& !tabuleiro[0][0].equals("[ ]")) {
			vencedor = tabuleiro[0][0];
			return true;
		}
		if (tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][0])
				&& !tabuleiro[0][2].equals("[ ]")) {
			vencedor = tabuleiro[0][2];
			return true;
		}
		return false;
	}

	public boolean verificaFimJogo() {
		if (verificaVencedor() || tentativas == 9) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verificaEmpate() {
		int cont = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (!this.tabuleiro[i][j].equals("[ ]")) {
					cont++;
				}
			}
		}
		if (cont == 9 && !verificaVencedor()) {
			System.out.println("Empate!");
			return true;
		}
		return false;
	}

	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		if (objeto == null || getClass() != objeto.getClass()) {
			return false;
		}
		Tabuleiro objTabuleiro = (Tabuleiro) objeto;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!this.tabuleiro[i][j].equals(objTabuleiro.tabuleiro[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	public String[][] copiarTabuleiro(String[][] tabuleiro) {
		String[][] tabCopia = new String[3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabCopia[i][j] = tabuleiro[i][j];
			}
		}
		return tabCopia;
	}

	public int gerarNumAleatorio() {
		return (int) (Math.random() * 3);
	}
}
