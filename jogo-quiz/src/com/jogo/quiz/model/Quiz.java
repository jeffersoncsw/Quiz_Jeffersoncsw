package com.jogo.quiz.model;

import java.io.Serializable;
import java.util.List;

public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pergunta;
	private String topico;
	private List<Resposta> respostas;
	
	public Quiz() {
		super();
	}
	public Quiz(String pergunta, String topico, List<Resposta> respostas) {
		super();
		this.pergunta = pergunta;
		this.topico = topico;
		this.respostas = respostas;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getTopico() {
		return topico;
	}
	public void setTopico(String topico) {
		this.topico = topico;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	@Override
	public String toString() {
		return "Quiz [pergunta=" + pergunta + ", topico=" + topico
				+ ", respostas=" + respostas + "]";
	}
}