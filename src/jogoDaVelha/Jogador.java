package jogoDaVelha;

public class Jogador {

	private String nome;
	private String simbolo;
	private boolean pc = false;

	public Jogador(String nome, String simbolo) {
		if (!this.testaNome(nome)) {
			throw new IllegalArgumentException("Por favor, digite seu nome!");
		} else {
			this.nome = nome;
		}

		if (!this.testaSimbolo(simbolo)) {
			throw new IllegalArgumentException("Digite um símbolo válido (X ou O)");
		} else {
			this.simbolo = simbolo;
		}
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
			System.out.println("\t*Digite um símbolo válido (X ou O)*");
			return false;
		}
		this.simbolo = simbolo;
		return true;
	}

	public boolean testaSimbolo(String simbolo) {
		if (simbolo.equals("X") || simbolo.equals("O")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testaNome(String nome) {
		if (!(nome == null) || !nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
