package com.jogo.quiz.business;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PerguntaBusiness {

	public static void cadastrar(String valor) {
		try {
			File file = new File("quiz.txt");
			if (!file.exists()) {
		        file.createNewFile();
		    }
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    
		    bw.write(valor);
		    bw.newLine();
		    bw.flush();
		    bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("== CADASTRO EFETUADO COM SUCESSO! ");
	}

	@SuppressWarnings("resource")
	public static String prepararArquivo(Scanner scanner) {
		System.out.println("= Vamos ao cadastro: \n");
		System.out.println("Digite um topico: ");
		String topico = scanner.next();
		
		scanner = new Scanner(System.in);
		System.out.println("Digite uma pergunta: ");
		String pergunta = scanner.nextLine();
		
		scanner = new Scanner(System.in);
		
		System.out.println("Digite a alternativa 1: ");
		String alternativa1 = scanner.next();		
		System.out.println("A alternativa 1 é verdadeira? Digite s(sim) ou n(nao).");
		String alternativa1IsCorreta = scanner.next();
		
		scanner = new Scanner(System.in);
		System.out.println("Digite a alternativa 2: ");
		String alternativa2 = scanner.next();		
		System.out.println("A alternativa 2 é verdadeira? Digite s(sim) ou n(nao).");
		String alternativa2IsCorreta = scanner.next();
		
		scanner = new Scanner(System.in);
		System.out.println("Digite a alternativa 3: ");
		String alternativa3 = scanner.next();		
		System.out.println("A alternativa 3 é verdadeira? Digite s(sim) ou n(nao).");
		String alternativa3IsCorreta = scanner.next();
		
		scanner = new Scanner(System.in);
		System.out.println("Digite a alternativa 4: ");
		String alternativa4 = scanner.next();		
		System.out.println("A alternativa 4 é verdadeira? Digite s(sim) ou n(nao).");
		String alternativa4IsCorreta = scanner.next();
		
		scanner = new Scanner(System.in);
		System.out.println("Digite a alternativa 5: ");
		String alternativa5 = scanner.next();		
		System.out.println("A alternativa 5 é verdadeira? Digite s(sim) ou n(nao).");
		String alternativa5IsCorreta = scanner.next();
		
		StringBuilder builder = new StringBuilder();
        builder.append(topico);
        builder.append(";");
        builder.append(pergunta);
        builder.append(";");
        builder.append(alternativa1);
        builder.append(";");
        builder.append(parserBoolean(alternativa1IsCorreta));
        builder.append(";");
        builder.append(alternativa2);
        builder.append(";");
        builder.append(parserBoolean(alternativa2IsCorreta));
        builder.append(";");
        builder.append(alternativa3);
        builder.append(";");
        builder.append(parserBoolean(alternativa3IsCorreta));
        builder.append(";");
        builder.append(alternativa4);
        builder.append(";");
        builder.append(parserBoolean(alternativa4IsCorreta));
        builder.append(";");
        builder.append(alternativa5);
        builder.append(";");
        builder.append(parserBoolean(alternativa5IsCorreta));
        builder.append(";");
		
		return builder.toString();
	}
	
	private static boolean parserBoolean(String valor) {
		if (valor.equals("s") || valor.equals("S")) {
			return true;
		}
		return false;
	}
}