/*package jogoDaVelha;

import java.util.Scanner;
import java.util.Stack;

public class jogoDaVelha {

	public static void main(String[] args) {

		System.out.println("              Instituto Federal Farroupilha - Campus São Vicente do Sul");
		System.out.println("                Tecnologia em Análise e Desenvolvimento de Sistemas");
		System.out.println("Disciplina: Programação III     Professor: Gustavo Rissetti       Data: 18/08/2024");
		System.out.println("Aluno: Rafael Müller Tischler                                        Turma: ADS 19");
		System.out.println("\n                          TRABALHO PRÁTICO 1 - JOGO DA VELHA\n");

		Scanner entrada = new Scanner(System.in);
		Stack<String[][]> jogadas = new Stack<>();

		Tabuleiro jogo = new Tabuleiro();
		Jogador jogador = null;
		Jogador pc = new Jogador();
		pc.setNome("Computador");
		pc.setPc(true);

		while (jogador == null) {
			try {
				System.out.print("Digite o NOME DO JOGADOR: ");
				String nome = entrada.nextLine();
				if (nome.trim().isEmpty()) {
					throw new IllegalArgumentException("O nome não pode ser vazio!");
				}
				System.out.print("Escolha seu SÍMBOLO: [X] ou [O]: ");
				String simbolo = entrada.nextLine().toUpperCase();
				jogador = new Jogador(nome, simbolo);
			} catch (IllegalArgumentException e) {
				System.out.println("\t*Erro ao CRIAR o JOGADOR*: " + e.getMessage());
			}
		}

		if (jogador.getSimbolo().equals("X")) {
			pc.setSimbolo("O");
		} else if (jogador.getSimbolo().equals("O")) {
			pc.setSimbolo("X");
		}

		while (!jogo.verificaFimJogo()) {
			jogadas.push(jogo.copiarTabuleiro(jogo.getTabuleiro()));

			System.out.print("\tDigite a linha (1,2,3): ");
			int linha = entrada.nextInt() - 1;
			System.out.print("\tDigite a coluna (1,2,3): ");
			int coluna = entrada.nextInt() - 1;

			jogo.realizaJogada(linha, coluna, jogador);
			jogo.imprimeTabuleiro();

			if (jogo.verificaVencedor()) {
				System.out.println("\t" + jogador.getNome() + " GANHOU!");
				break;
			} else if (jogo.verificaFimJogo()) {
				System.out.println("\tO jogo EMPATOU!");
				break;
			}

			boolean vezDoPC = true;
			while (vezDoPC) {
				int linhaPc = jogo.gerarNumAleatorio();
				int colunaPc = jogo.gerarNumAleatorio();
				if (jogo.realizaJogada(linhaPc, colunaPc, pc)) {
					System.out.println(
							"\tO " + pc.getNome() + " jogou na posição (" + (linhaPc + 1) + "," + (colunaPc + 1) + ")");
					vezDoPC = false;
				}
			}
			jogo.imprimeTabuleiro();

			if (jogo.verificaVencedor()) {
				System.out.println("\t" + pc.getNome() + " GANHOU!");
				break;
			} else if (jogo.verificaFimJogo()) {
				System.out.println("\tO jogo EMPATOU!");
			}

			System.out.print("\tDeseja DESFAZER a última jogada? (S/N)\tResposta: ");
			String resposta = entrada.next();
			if (resposta.equalsIgnoreCase("S") && !jogadas.isEmpty()) {
				jogo.setTabuleiro(jogadas.pop());
				jogo.imprimeTabuleiro();
			}
		}

	}
}
*/