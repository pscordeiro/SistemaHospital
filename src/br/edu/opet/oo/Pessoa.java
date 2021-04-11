package br.edu.opet.oo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	private String Nome;
	private String CPF;
	private String Genero;
	private Date DtaNasc;
	private String Telefone;
	
	public Pessoa(String Nome, String CPF, String Genero, Date DtaNasc, String Telefone) {
		
		this.Nome = Nome;
		this.CPF = CPF;
		this.Genero = Genero;
		this.DtaNasc = DtaNasc;
		this.Telefone = Telefone;
		
	}
	
	public double getSalario() {
		return 0.0;
	}
	
	public String getPerfil() {
		return "Pessoa";
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public Date getDtaNasc() {
		return DtaNasc;
	}
	public void setDtaNasc(Date dtaNasc) {
		DtaNasc = dtaNasc;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public int getIdade() {
		int idade = -1;
		
		SimpleDateFormat yearSDF = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthSDF = new SimpleDateFormat("MM");
		SimpleDateFormat daySDF = new SimpleDateFormat("DD");
		Date dt = new Date();
		
		int yearBt = Integer.parseInt(yearSDF.format(this.DtaNasc));
		int yearNow = Integer.parseInt(yearSDF.format(dt));

		int monthBt = Integer.parseInt(monthSDF.format(this.DtaNasc));
		int monthNow = Integer.parseInt(monthSDF.format(dt));
		
		int dayBt = Integer.parseInt(daySDF.format(this.DtaNasc));
		int dayNow = Integer.parseInt(daySDF.format(dt));
		
		idade = yearNow - yearBt;
		
		if(monthNow < monthBt)
			idade--;
		if(monthNow == monthBt) {
			if(dayNow < dayBt)
				idade--;
		}
		
		return idade;
	}
	
}
