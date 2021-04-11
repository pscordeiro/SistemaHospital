package br.edu.opet.oo;

import java.util.Date;

public class Medico extends Pessoa {
	
	private Especialidade especalidade;
	private int CRM;
	
	public Medico(String Nome, String CPF, String Genero, Date DtaNasc, String Telefone, Especialidade especalidade, int CRM) {
		
		super(Nome, CPF, Genero, DtaNasc, Telefone);
		this.especalidade  = especalidade;
		this.CRM = CRM;
		
	}

	public Especialidade getEspecalidade() {
		return especalidade;
	}

	public void setEspecalidade(Especialidade especalidade) {
		this.especalidade = especalidade;
	}
	
	public int getCRM() {
		return CRM;
	}

	public void setCRM(int CRM) {
		this.CRM = CRM;
	}

	public double getSalario() {
		return this.especalidade.getSalario();
	}
	
	public String getPerfil() {
		return "Medico";
	}

}
