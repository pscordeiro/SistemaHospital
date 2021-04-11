package br.edu.opet.oo;

import java.util.Date;

public class Administrativo extends Pessoa {

	private double salario;
	
	public Administrativo(String Nome, String CPF, String Genero, Date DtaNasc, String Telefone, double salario) {
		
		super(Nome, CPF, Genero, DtaNasc, Telefone);
		this.salario = salario;
		
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getPerfil() {
		return "Administrativo";
	}
	
}
