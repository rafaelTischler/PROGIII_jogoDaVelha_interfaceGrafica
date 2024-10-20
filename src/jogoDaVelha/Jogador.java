package jogoDaVelha;

public class Jogador {
	private String nome;
	private String simbolo;
	protected Tabuleiro tab;
	private boolean pc = false;

	public Jogador(String nome, String simbolo, Tabuleiro tab) {
		if (!this.testaNome(nome)) {
			throw new IllegalArgumentException("Por favor, DIGITE SEU NOME!");
		} else {
			this.nome = nome;
		}
		if (!this.testaSimbolo(simbolo)) {
			throw new IllegalArgumentException("Digite um SÍMBOLO VÁLIDO (X ou O)");
		} else {
			this.simbolo = simbolo;
		}
		this.tab = tab;
	}

	public Jogador() {
	}

	public boolean isPc() {
		return pc;
	}

	public void setPc(boolean pc) {
		this.pc = pc;
	}

	public String getNome() {
		return nome;
	}

	public boolean setNome(String nome) {
		if (!this.testaNome(nome)) {
			System.out.println("\tPor favor, INFORME O NOME DO JOGADOR!");
			return false;
		}
		this.nome = nome;
		return true;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public boolean setSimbolo(String simbolo) {
		if (!this.testaSimbolo(simbolo)) {
			System.out.println("\t*Digite um SIMBOLO VÁLIDO (X ou O)*");
			return false;
		}
		this.simbolo = simbolo;
		return true;
	}

	public boolean testaSimbolo(String simbolo) {
		return simbolo.equals("X") || simbolo.equals("O");
	}

	public boolean testaNome(String nome) {
		return nome != null && !nome.trim().isEmpty();
	}

	public void fazerJogada(int linha, int coluna, Jogador jogador) {
		if (this.tab == null) {
			throw new NullPointerException("Tabuleiro NÃO INICIALIZADO");
		}
		if (tab.verificaPosicao(linha, coluna)) {
			tab.realizaJogada(linha, coluna, jogador);
		}
	}

	public void setTabuleiro(Tabuleiro tab) {
		this.tab = tab;
	}
}
