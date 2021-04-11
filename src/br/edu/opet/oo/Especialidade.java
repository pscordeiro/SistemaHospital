package br.edu.opet.oo;

import java.util.HashMap;
import com.opet.util.Reader;
import br.edu.opet.app.App;
import br.edu.opet.app.Menus;

public class Especialidade {
	
	private int id;
	private String descricao;
	private double salario;
	
	public Especialidade(int id, String descricao, double salario) {
		this.descricao = descricao;
		this.id = id;
		this.salario = salario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Especialidade() {}
	
	public Especialidade getEspecialidade(HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
			
		do {
			
			Menus.listarEspecialidade(lEspecialidade);
			App.linhas();
			System.out.println("Selecione a especialidade ou digite 0 para cadastrar uma nova: ");
			System.out.println("Opção: ");
			int opc = Reader.readInt();
			boolean origemGet = true;
			
			if(lEspecialidade.containsKey(opc)) {
				return lEspecialidade.get(opc);
			}
			else if(opc == 0) {				
				opc = Menus.cadEspecialidade(lEspecialidade, origemGet);
				return lEspecialidade.get(opc);
			}
			System.out.println("");
			System.out.println("Opção Inválida !!");
			
		}while(true);
		
	}
	
	

}
