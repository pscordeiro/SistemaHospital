package br.edu.opet.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import com.opet.util.Reader;

import br.edu.opet.oo.Administrativo;
import br.edu.opet.oo.Enfermeiro;
import br.edu.opet.oo.Especialidade;
import br.edu.opet.oo.Medico;
import br.edu.opet.oo.Pessoa;
import br.edu.opet.app.Menus;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<Pessoa> lPessoa = new ArrayList<Pessoa>();
		
		HashMap<Integer, Especialidade> lEspecialidade = new HashMap<Integer, Especialidade>();
		
		especialidadeManual(lEspecialidade);
		cadastroAutomatico(lPessoa, lEspecialidade);
		int opc = menu();
		
		while(opc != 0) {
			
			switch(opc) {
			case 1:
				Menus.Cadastros(lPessoa, lEspecialidade);
				break;
			case 2: 
				Menus.Listar(lPessoa, lEspecialidade);
				break;
			case 3:
				Menus.Atualizar(lPessoa, lEspecialidade);
				break;
			case 4:
				Menus.Deletar(lPessoa, lEspecialidade);
				break;
			case 5:
				cadastroAutomatico(lPessoa, lEspecialidade);
				break;
			default:System.out.println("Opção Inválida");
			}
			
			opc = menu();
			
		}
		
	}

	public static int menu() throws Exception {
		System.out.println("");		
		System.out.println("=================== Menus ====================");		
		System.out.println("");	
		System.out.println("1 - Menu Cadastrar");
		System.out.println("2 - Menu Listar");
		System.out.println("3 - Menu Atualizar");
		System.out.println("4 - Menu Deletar");
		System.out.println("0 - Sair");
		System.out.println("");	
		
		System.out.println("Opção Escolhida: ");	
		int opc = Reader.readInt();
		System.out.println("");	
		return opc;
		
	}

	public static int perfil() throws Exception {	
		System.out.println("=================== Perfil ===================");		
		System.out.println("");	
		System.out.println("1 - Medico");
		System.out.println("2 - Enfermeiro");
		System.out.println("3 - Administrativo");
		System.out.println("");	

		int opc = Reader.readInt();
		System.out.println("");	
		return opc;
	}
	
	public static boolean validaPerfil(int opc) {
		boolean valido = false;
		switch(opc) {
			case 1:
			case 2:
			case 3:
				valido = true;
		}
		
		if(!valido) {
			System.out.println("");	
			System.out.println("Perfil Inválido !");
			System.out.println("");	
		}
		return valido;
	}
	
	public static void linhas() {	
		
		System.out.println("==============================================");
		
	}
	
	private static void especialidadeManual(HashMap<Integer, Especialidade> lEspecialidade) {
		
		Especialidade esp1 = new Especialidade(1, "Ortopedista", 4900.00);
		lEspecialidade.put(esp1.getId(), esp1);
		
		Especialidade esp2 = new Especialidade(2, "Clinico Geral", 3000.00);
		lEspecialidade.put(esp2.getId(), esp2);
		
	}
	
	public static void cadastroAutomatico(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws ParseException {
		
		Pessoa p = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String Nome = "Paulinho Gameplay";
		String CPF = "123456";
		String Genero = "M";
		String Telefone = "40028922";
		Especialidade esp = lEspecialidade.get(1);
		int CRM = 14141;
		String strDtaNasc = "11/03/2001";
		Date DtaNasc = sdf.parse(strDtaNasc);
		
		p = new Medico(Nome, CPF, Genero, DtaNasc, Telefone, esp, CRM);
		lPessoa.add(p);
			
		String Nome2 = "Rogeirinho";
		String CPF2 = "36362514";
		String Genero2 = "M";
		String Telefone2 = "08008000";
		int CargaHoraria = 25;
		String strDtaNasc2 = "14/08/1996";
		Date DtaNasc2 = sdf.parse(strDtaNasc2);
		
		p = new Enfermeiro(Nome2, CPF2, Genero2, DtaNasc2, Telefone2, CargaHoraria);
		lPessoa.add(p);
		
		String Nome3 = "Alice";
		String CPF3 = "652154";
		String Genero3 = "F";
		String Telefone3 = "30550384";
		Double Salario3 = 4500.0;
		String strDtaNasc3 = "14/02/2005";
		Date DtaNasc3 = sdf.parse(strDtaNasc3);
		
		p = new Administrativo(Nome3, CPF3, Genero3, DtaNasc3, Telefone3, Salario3);
		lPessoa.add(p);
		
	}

}
