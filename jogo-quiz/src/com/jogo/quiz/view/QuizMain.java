package com.jogo.quiz.view;

import java.util.List;
import java.util.Scanner;

import com.jogo.quiz.business.PerguntaBusiness;
import com.jogo.quiz.business.QuizBusiness;
import com.jogo.quiz.model.Quiz;

public class QuizMain {
	
	private static List<Quiz> quizLista;

	public static void main(String[] args) {
		
		System.out.println("====================================");
		System.out.println("==== SEJA BEM VINDO - JOGO QUIZ ====");
		System.out.println("====================================");
		System.out.println("\n O que deseja fazer? Para cadastrar um pergunta digite 1 ou 2 para ir ao jogo!");
		
		Scanner scanner = new Scanner(System.in);
		menuSistema(scanner);		
	}

	private static void menuSistema(Scanner scanner) {
		int menu = scanner.nextInt();
		System.out.println("== Menu selecionado: " + menu);
		
		if (menu == 1) {
			adicionarQuiz(scanner);			
		} else if (menu == 2) {
			playQuiz();
		} else {
			System.out.println("Erro, nenhum menu " + menu + " encontrado em nosso sistema!");
		}
	}
	
	@SuppressWarnings("resource")
	private static void adicionarQuiz(Scanner scanner) {
		
		String valor = PerguntaBusiness.prepararArquivo(scanner);
		
		scanner = new Scanner(System.in);
		System.out.println("== Essas alternativas estao corretas? 1(SIM) / Outros numeros(NAO)");
		int quizIsCorreto = scanner.nextInt();
		
		if (quizIsCorreto == 1) {
			PerguntaBusiness.cadastrar(valor);
		} else {
			scanner = new Scanner(System.in);
			System.out.println("== Deseja cadastrar novamente? 1(SIM) / Outros numeros(NAO)");
			int isCadastrar = scanner.nextInt();
			if (isCadastrar == 1) {
				PerguntaBusiness.prepararArquivo(scanner);
			} else {
				System.out.println("== Obrigado pelas informações!");
				menuSistema(scanner);
			}			
		} 
	}

	private static void playQuiz() {
		System.out.println("=== Começando o jogo quiz...");
		quizLista = QuizBusiness.carregarPerguntas();
		int respostaCorreta = 0;
		int respostaErrada = 0;
		if (quizLista != null && !quizLista.isEmpty()) {
			for (Quiz quiz : quizLista) {
				if (quiz != null) {
					boolean isRespostaCorreta = QuizBusiness.player(quiz);
					if (isRespostaCorreta) {
						respostaCorreta++;
					} else {
						respostaErrada++;
					}
				}
			}
			System.out.println("- QTDADE DE RESPOSTA CORRETA: " + respostaCorreta);
			System.out.println("- QTDADE DE RESPOSTA ERRADA: " + respostaErrada);
			System.out.println("=== FIM DO JOGO - QUIZ ===");
		} else {
			System.out.println("\n\n NAO EXISTE NENHUM CADASTRO, POR GENTILEZA ACESSE O MENU 1 PARA CADASTRAR!");
			Scanner scanner = new Scanner(System.in);
			menuSistema(scanner);
		}
	}
}