package com.jogo.quiz.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jogo.quiz.model.Quiz;
import com.jogo.quiz.model.Resposta;

public class QuizBusiness {
	
	static int numeroDaPergunta = 1;

	@SuppressWarnings("resource")
	public static List<Quiz> carregarPerguntas() {
		List<Quiz> lista = new ArrayList<Quiz>();
		try {
			String linha = null;
		    BufferedReader br = new BufferedReader(new FileReader("quiz.txt"));
			while ((linha = br.readLine()) != null) {
				Scanner scanner = new Scanner(linha).useDelimiter(";");
				int qtdColunas = 0;
				Quiz quiz = new Quiz();
				List<Resposta> respostas = new ArrayList<Resposta>();
				String alternativa = null;
				boolean isAlternativaCorreta = false;
				while (scanner.hasNext()) {
					qtdColunas++;
					String value = scanner.next();
					if (qtdColunas == 1) {
						quiz.setTopico(value);
					} else if (qtdColunas == 2) {
						quiz.setPergunta(value);
						
					} else if (qtdColunas == 3) {
						alternativa = value;
					} else if (qtdColunas == 4) {
						isAlternativaCorreta = Boolean.valueOf(value);
						respostas.add(new Resposta(alternativa, isAlternativaCorreta));
						alternativa = null;
						isAlternativaCorreta = false;
					} else if (qtdColunas == 5) {
						alternativa = value;
					} else if (qtdColunas == 6) {
						isAlternativaCorreta = Boolean.valueOf(value);
						respostas.add(new Resposta(alternativa, isAlternativaCorreta));
						alternativa = null;
						isAlternativaCorreta = false;
					} else if (qtdColunas == 7) {
						alternativa = value;
					} else if (qtdColunas == 8) {
						isAlternativaCorreta = Boolean.valueOf(value);
						respostas.add(new Resposta(alternativa, isAlternativaCorreta));
						alternativa = null;
						isAlternativaCorreta = false;
					} else if (qtdColunas == 9) {
						alternativa = value;
					} else if (qtdColunas == 10) {
						isAlternativaCorreta = Boolean.valueOf(value);
						respostas.add(new Resposta(alternativa, isAlternativaCorreta));
						alternativa = null;
						isAlternativaCorreta = false;
					} else if (qtdColunas == 11) {
						alternativa = value;
					} else if (qtdColunas == 12) {
						isAlternativaCorreta = Boolean.valueOf(value);
						respostas.add(new Resposta(alternativa, isAlternativaCorreta));
						alternativa = null;
						isAlternativaCorreta = false;
						quiz.setRespostas(respostas);
					}
				}
				lista.add(quiz);
				scanner.close();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@SuppressWarnings("resource")
	public static boolean player(Quiz quiz) {
		
		System.out.println("\n === VAMOS PARA A PERGUNTA NUMERO: " + numeroDaPergunta + " ===");
		System.out.println(quiz.getPergunta());
		boolean isRespostaCorreta = false;
		
		if (quiz.getRespostas() != null && !quiz.getRespostas().isEmpty()) {
			System.out.println("= VAMOS AS ALTERNATIVAS!");
			int alternativa = 1;
			int alternativaCorreta = 0;
			for (Resposta resposta : quiz.getRespostas()) {
				System.out.println(alternativa + " - " + resposta.getAlternativa());
				if (resposta.isAlternativaCorreta()) {
					alternativaCorreta = alternativa;
				}
				alternativa++;
			}
			System.out.println("= QUAL DAS ALTERNATIVAS É A CORRETA?");
			Scanner scanner = new Scanner(System.in);
			int resposta = scanner.nextInt();
			
			if (resposta == alternativaCorreta) {
				isRespostaCorreta = true;
				System.out.println("== CERTA RESPOSTA! ");
			} else {
				System.out.println("== ERRADA RESPOSTA! ");
			}
		}		
		numeroDaPergunta++;
		return isRespostaCorreta;
	}
}