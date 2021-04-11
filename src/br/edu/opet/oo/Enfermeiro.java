package br.edu.opet.oo;

import java.util.Date;

public class Enfermeiro extends Pessoa {
	
	//Carga horaria Semanal
	private int cargaHoraria;
	
	public Enfermeiro(String Nome, String CPF, String Genero, Date DtaNasc, String Telefone, int cargaHoraria) {
		
		super(Nome, CPF, Genero, DtaNasc, Telefone);
		this.cargaHoraria = cargaHoraria;
		
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public double getSalario() {
		return cargaHoraria * 100.00;
	}
	public String getPerfil() {
		return "Enfermeiro";
	}

}
