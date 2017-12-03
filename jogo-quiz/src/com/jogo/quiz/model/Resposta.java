package com.jogo.quiz.model;

import java.io.Serializable;

public class Resposta implements Serializable {

	private static final long serialVersionUID = 1L;

	private String alternativa;
	private boolean isAlternativaCorreta;

	public Resposta(String alternativa, boolean isAlternativaCorreta) {
		super();
		this.alternativa = alternativa;
		this.isAlternativaCorreta = isAlternativaCorreta;
	}
	
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	public boolean isAlternativaCorreta() {
		return isAlternativaCorreta;
	}
	public void setAlternativaCorreta(boolean isAlternativaCorreta) {
		this.isAlternativaCorreta = isAlternativaCorreta;
	}
	@Override
	public String toString() {
		return "Resposta [alternativa=" + alternativa
				+ ", isAlternativaCorreta=" + isAlternativaCorreta + "]";
	}
}