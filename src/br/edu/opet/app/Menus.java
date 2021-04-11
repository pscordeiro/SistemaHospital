package br.edu.opet.app;

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

public class Menus {

	public static void Cadastros(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		int opc = 0;
		
		while(opc != 3) {
		
			System.out.println("=============== Menu Cadastros ===============");
			System.out.println("");	
			System.out.println("1 - Cadastrar Pessoa");
			System.out.println("2 - Cadastrar Especialidade");
			System.out.println("3 - Voltar ao menu anterior ");
			System.out.println("");
			System.out.println("Opção Escolhida: ");	
			opc = Reader.readInt();
			System.out.println("");
			boolean origemGet = false;
			
			switch(opc) {
			
				case 1:
					cadPessoas(lPessoa,lEspecialidade);
					break;
				case 2: 
					cadEspecialidade(lEspecialidade, origemGet);
					break;
				case 3:
					break;
				default:System.out.println("Opção Inválida");
				
			}		
		}		
	}

	public static void Listar(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		int opc = 0;
		while(opc != 3) {
		
			System.out.println("================= Menu Listar ================");
			System.out.println("");	
			System.out.println("1 - Listar Pessoas");
			System.out.println("2 - Listar Especialidades");
			System.out.println("3 - Voltar ao menu anterior ");
			System.out.println("");
			System.out.println("Opção Escolhida: ");	
			opc = Reader.readInt();
			System.out.println("");
							
			switch(opc) {
			
				case 1:
					listarPessoas(lPessoa);
					break;
				case 2: 
					listarEspecialidade(lEspecialidade);
					break;
				case 3:
					break;
				default:System.out.println("Opção Inválida");
				
			}			
		}			
	}
	
	public static void Atualizar(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		int opc = 0;	
		while(opc != 3) {
		
			System.out.println("=============== Menu Atualizar ===============");
			System.out.println("");	
			System.out.println("1 - Atualizar Pessoas");
			System.out.println("2 - Atualizar Especialidades");
			System.out.println("3 - Voltar ao menu anterior ");
			System.out.println("");
			System.out.println("Opção Escolhida: ");	
			opc = Reader.readInt();
			System.out.println("");
							
			switch(opc) {
			
				case 1:
					atualizarPessoas(lPessoa, lEspecialidade);
					break;
				case 2: 
					atualizarEspecialidade(lEspecialidade);
					break;
				case 3:
					break;
				default:System.out.println("Opção Inválida");
				
			}			
		}			
		
	}

	public static void Deletar(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		int opc = 0;	
		while(opc != 3) {
		
			System.out.println("================= Menu Delete ================");
			System.out.println("");	
			System.out.println("1 - Deletar Pessoas");
			System.out.println("2 - Deletar Especialidades");
			System.out.println("3 - Voltar ao menu anterior ");
			System.out.println("");
			System.out.println("Opção Escolhida: ");	
			opc = Reader.readInt();
			System.out.println("");
							
			switch(opc) {
			
				case 1:
					deletarPessoas(lPessoa);
					break;
				case 2: 
					deletarEspecialidade(lEspecialidade);
					break;
				case 3:
					break;
				default:System.out.println("Opção Inválida");
				
			}			
		}			
		
	}

	public static void cadPessoas(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
			
		int perfil;
		
		Pessoa p = null;
		
		do {
			perfil = App.perfil();
		}while(!App.validaPerfil(perfil));
		
		System.out.println("============== Cadastrar Pessoas ===============");		
		System.out.println("");	
		System.out.println("Nome: ");
		String nome = Reader.readString();
		System.out.println("CPF: ");
		String cpf = Reader.readString();
		System.out.println("Genero: ");
		String genero = Reader.readString();
		System.out.println("Data de nascimento ex: (01/01/2000): ");
		String strDtaNasc = Reader.readString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date DtaNasc = sdf.parse(strDtaNasc);
		System.out.println("Telefone: ");
		String telefone = Reader.readString();
		
		switch(perfil) {
		case 1: 
			Especialidade esp = new Especialidade();
			esp = esp.getEspecialidade(lEspecialidade);
						
			System.out.println("CRM: ");
			int CRM = Reader.readInt();
			p = new Medico(nome, cpf, genero, DtaNasc, telefone, esp, CRM);
			break;
		case 2:
			System.out.println("Carga Horaria: ");
			int cargaHoraria = Reader.readInt();
			p = new Enfermeiro(nome, cpf, genero, DtaNasc, telefone, cargaHoraria);
			break;
		case 3:
			System.out.println("Salario: ");
			double salario = Reader.readDouble();
			p = new Administrativo(nome, cpf, genero, DtaNasc, telefone, salario);
			break;
		}
		
		lPessoa.add(p);
		System.out.println("");
		System.out.println("============ Cadastro Finalizado =============");
		System.out.println("");
	}
	
	public static int cadEspecialidade(HashMap<Integer, Especialidade> lEspecialidade, boolean origemGet) throws Exception {	
		
		int loop = 0;
		
		if(!(origemGet)){			
			listarEspecialidade(lEspecialidade);
		}
		
		System.out.println("");	
		System.out.println("======= Cadastrar nova especialidade =========");	
		System.out.println("");
		int id = (lEspecialidade.size() + 1);

		while(loop != 1) {

		
		System.out.println("Informe o nome da especialidade: ");
		String descricao = Reader.readString();
	
			
			HashMap<String, Especialidade> lEspecialidadeStr = new HashMap<String, Especialidade>();
					
			for (Especialidade esp : lEspecialidade.values()) {
				
				String chave = esp.getDescricao();
				lEspecialidadeStr.put(chave, esp);
				
			}
					
			if(lEspecialidadeStr.containsKey(descricao)) {
				App.linhas();
				System.out.println("");
				System.out.println("Essa especialidade já existe!!");
				System.out.println("");
				
				if(origemGet == true){	
					
					id = lEspecialidadeStr.get(descricao).getId();
					System.out.println("Selecionando: " + descricao);
					System.out.println("");
					return id;
				}
				
				loop = 1;
			}
			else {			
				System.out.println("Informe o salário da especialidade: ");
				double salario = Reader.readDouble();
				System.out.println("");

				Especialidade esp = new Especialidade(id, descricao, salario);
				lEspecialidade.put(esp.getId(),esp);
				App.linhas();
				System.out.println("");
				System.out.println("Especialidade cadastrada com sucesso !!");
				System.out.println("");
				App.linhas();
				loop = 1;
			}		
		}
		return id;		
	}
	
	public static void listarPessoas(ArrayList<Pessoa> lPessoa) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("");		
		System.out.println("============== Listar Pessoas ================");
		System.out.println("");		

		if(lPessoa.isEmpty()) {
			System.out.println("Nenhuma pessoa cadastrada !! ");
			System.out.println("");
		}
		
		for(int i = 0; i < lPessoa.size(); i++) {
			
			Pessoa p = lPessoa.get(i);
			
			System.out.println("");		
			
			if(p instanceof Administrativo) {
				System.out.println("================ " + p.getPerfil() + " ==============");
			}
			
			if(p instanceof Medico) {
				System.out.println("==================== " + p.getPerfil() + " ==================");
			}
			
			if(p instanceof Enfermeiro) {
				System.out.println("================== " + p.getPerfil() + " ================");
			}
			
			//System.out.println("==================== Medico ==================");
			//System.out.println("================ Administrativo ==============");
			//System.out.println("================== Enfermeiro ================");	
			//System.out.println("============ Cadastro Finalizado =============");
			System.out.println("");		
			System.out.println("Nome = " + p.getNome());
			System.out.println("CPF = " + p.getCPF());
			System.out.println("Genero = " + p.getGenero());
			System.out.println("Data de nascimento = " + sdf.format(p.getDtaNasc()));
			System.out.println("Idade = " + p.getIdade());
			System.out.println("Telefone = " + p.getTelefone());
			System.out.println("Salario = " + p.getSalario());	
					
			//Se pessoa for do tipo médico
			if(p instanceof Medico) {				
				System.out.println("Especialidade: " + ((Medico)p).getEspecalidade().getDescricao());
				System.out.println("CRM: " + ((Medico)p).getCRM());
			}
			
			//Se pessoa for do tipo Enfermeiro
			if(p instanceof Enfermeiro) {				
				System.out.println("Carga Horaria: " + ((Enfermeiro)p).getCargaHoraria());
			}
			
			//Se pessoa for do tipo Administrativo
			if(p instanceof Administrativo) {				
				
			}
			
		}
		
		System.out.println("");	
		App.linhas();
		System.out.println("");	

	}
			
	public static void listarEspecialidade(HashMap<Integer, Especialidade> lEspecialidade) {	
		
		System.out.println("======== Especialidades cadastradas ==========");	
		System.out.println("");		
		
		if(lEspecialidade.isEmpty()) {
			System.out.println("Nenhuma especialidade cadastrada !! ");
			System.out.println("");
		}

		for (Especialidade esp : lEspecialidade.values()) {		
			System.out.println(esp.getId() + " - " + esp.getDescricao() + " - " + esp.getSalario() );
		}
		
		System.out.println("");		
	}

	private static void atualizarEspecialidade(HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		System.out.println("============= Atualizar Especialidade ============");	
		System.out.println("");	
		
		int opc = 0;
		
		do {
			
			if(lEspecialidade.isEmpty()) {
				System.out.println("Nenhuma especialidade cadastrada !! ");
				System.out.println("");
				break;
			}
			
			listarEspecialidade(lEspecialidade);
			
			System.out.println("Qual especialidade deseja atualizar ?");
			System.out.println("Opção Escolhida: ");	
			opc = Reader.readInt();
			System.out.println("");
			
			try {
				Especialidade esp = new Especialidade();
				
				System.out.println("Digite a nova Descrição da especialidade");
				String descricao = Reader.readString();
				System.out.println("Digite o novo Salario da especialidade");
				double salario = Reader.readDouble();
				
				esp.setDescricao(descricao);
				esp.setSalario(salario);
				lEspecialidade.put(opc, esp);
				
				App.linhas();
				System.out.println("");
				System.out.println("Especialidade atualizada com sucesso !! ");
				System.out.println("");
				break;
			}
			catch(Exception exception){
				App.linhas();
				System.out.println("");
				System.out.println("Opção Inválida !!");
				System.out.println("");
				App.linhas();
			}
			
		}while(true);			
		
	}

	private static void atualizarPessoas(ArrayList<Pessoa> lPessoa, HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		System.out.println("============= Atualizar Pessoas ============");	
		System.out.println("");	
		
		int opc = 0;
		
		boolean atualizado = false;
		
		do {
			
			if(lPessoa.isEmpty()) {
				System.out.println("Nenhuma pessoa cadastrada !! ");
				System.out.println("");
				atualizado = true;
				break;
			}
			
			for(int i = 0; i< lPessoa.size();i++) {
				System.out.println("Id: " + (i + 1)  + " - Nome: " +  lPessoa.get(i).getNome() + " - Perfil: " + lPessoa.get(i).getPerfil());
			}
			
			System.out.println("");
			System.out.println("Qual pessoa deseja atualizar ?");
			System.out.println("Digite o Id: ");
			opc = Reader.readInt();
			System.out.println("");
			opc += -1;
			Pessoa p = lPessoa.get(opc);
			
			App.linhas();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("");			
			System.out.println("1- " + "Nome = " + p.getNome());
			System.out.println("2- " + "CPF = " + p.getCPF());
			System.out.println("3- " + "Genero = " + p.getGenero());
			System.out.println("4- " + "Data de nascimento = " + sdf.format(p.getDtaNasc()));
			System.out.println("5- " + "Telefone = " + p.getTelefone());
			System.out.println("6- " + "Salario = " + p.getSalario());						
						
			if(p instanceof Medico) {				
				System.out.println("7- " + "CRM: " + ((Medico)p).getCRM());
			}			
			
			if(p instanceof Enfermeiro) {				
				System.out.println("7- " + "Carga Horaria: " + ((Enfermeiro)p).getCargaHoraria());
			}
			
			System.out.println("Qual informação deseja alterar ?");
			int opcao = Reader.readInt();
			
			switch(opcao) {
			case 1:
				System.out.println("Digite o novo nome: ");
				String novoNome = Reader.readString();
				p.setNome(novoNome);
				lPessoa.set(opc , p);
				atualizado = true;
				App.linhas();
				System.out.println("");
				System.out.println("Nome atualizado com sucesso !!");
				System.out.println("");
				break;
			case 2:
				System.out.println("Digite o CPF: ");
				String novoCPF = Reader.readString();
				p.setCPF(novoCPF);
				lPessoa.set(opc, p);
				atualizado = true;
				App.linhas();
				System.out.println("");
				System.out.println("CPF atualizado com sucesso !!");
				System.out.println("");
				break;
			case 3:
				System.out.println("Digite o novo gênero: ");
				String novoGenero = Reader.readString();
				p.setGenero(novoGenero);
				lPessoa.set(opc, p);
				atualizado = true;
				App.linhas();
				System.out.println("");
				System.out.println("Gênero atualizado com sucesso !!");
				System.out.println("");
				break;
			case 4:
				System.out.println("Digite a nova data de nascimento (01/01/2001): ");
				String strDtaNasc = Reader.readString();
				Date DtaNasc = sdf.parse(strDtaNasc);
				p.setDtaNasc(DtaNasc);
				lPessoa.set(opc, p);
				atualizado = true;
				App.linhas();
				System.out.println("");
				System.out.println("Data de nascimento atualizada com sucesso !!");
				System.out.println("");
				break;
			case 5:
				System.out.println("Digite o novo telefone: ");
				String novoTelefone = Reader.readString();
				p.setTelefone(novoTelefone);
				lPessoa.set(opc, p);
				atualizado = true;
				App.linhas();
				System.out.println("");
				System.out.println("Telefone atualizado com sucesso !!");
				System.out.println("");
				break;
			case 6:			
				
				if(p instanceof Administrativo) {				
					System.out.println("Digite o novo salário: ");
					double novoSalario = Reader.readDouble();
					((Administrativo)p).setSalario(novoSalario);
					lPessoa.set(opc, p);
					atualizado = true;
					App.linhas();
					System.out.println("");
					System.out.println("Salário atualizado com sucesso !!");
					System.out.println("");
					break;
				}
				
				if(p instanceof Medico) {
					System.out.println("Mude a especialidade para alterar o salário do médico");
					Especialidade esp = new Especialidade();
					esp = esp.getEspecialidade(lEspecialidade);					
					((Medico)p).setEspecalidade(esp);	
					lPessoa.set(opc, p);
					atualizado = true;	
					App.linhas();
					System.out.println("");
					System.out.println("Especialidade/Salário atualizada com sucesso !!");
					System.out.println("");
				}
				
				if(p instanceof Enfermeiro) {					
					System.out.println("Digite a nova carga horaria: ");
					int cargaHoraria = Reader.readInt();
					((Enfermeiro) p).setCargaHoraria(cargaHoraria);
					lPessoa.set(opc, p);
					atualizado = true;	
					App.linhas();
					System.out.println("");
					System.out.println("Carga horaria atualizada com sucesso !!");
					System.out.println("");
				}
				break;
			case 7:
				
				if(p instanceof Medico) {		
					
					int novoCRM = Reader.readInt();
					((Medico) p).setCRM(novoCRM);
					lPessoa.set(opc, p);
					atualizado = true;		
					App.linhas();
					System.out.println("");
					System.out.println("CRM atualizado com sucesso !!");
					System.out.println("");
				}
				
				if(p instanceof Enfermeiro) {					
					System.out.println("Digite a nova carga horaria: ");
					int cargaHoraria = Reader.readInt();
					((Enfermeiro) p).setCargaHoraria(cargaHoraria);
					lPessoa.set(opc, p);
					atualizado = true;
					App.linhas();
					System.out.println("");
					System.out.println("Carga horaria atualizada com sucesso !!");
					System.out.println("");
				}
				
				if(p instanceof Administrativo) {	
					App.linhas();
					System.out.println("");
					System.out.println("Opção inválida");
					System.out.println("");
				}
				break;
				default:
					System.out.println("");
					System.out.println("Opção inválida");
					System.out.println("");
			}
									
		}while(atualizado == false);	
		
	}
	
	private static void deletarEspecialidade(HashMap<Integer, Especialidade> lEspecialidade) throws Exception {
		
		System.out.println("============= Deletar Especialidade ============");	
		System.out.println("");	
		
		int opc = 0;
		
		do {
			
			if(lEspecialidade.isEmpty()) {
				System.out.println("Nenhuma especialidade cadastrada !! ");
				System.out.println("");
				break;
			}
			
			listarEspecialidade(lEspecialidade);
					
			System.out.println("Qual especialidade deseja remover ?");
			System.out.println("Opção Escolhida: ");	
			opc = Reader.readInt();
			System.out.println("");
			
			try {
				lEspecialidade.remove(opc);
				App.linhas();
				System.out.println("");
				System.out.println("Especialidade removida com sucesso !! ");
				System.out.println("");
				break;
			}
			catch(Exception e){
				App.linhas();
				System.out.println("");
				System.out.println("Opção Inválida !!");
				System.out.println("");
				App.linhas();
			}
			
		}while(true);			
		
	}

	private static void deletarPessoas(ArrayList<Pessoa> lPessoa) throws Exception {	
		
		System.out.println("=============== Deletar Pessoas ==============");	
		System.out.println("");	
			
		int opc = 0;	
		
		do {
			
			if(lPessoa.isEmpty()) {
				System.out.println("Nenhuma pessoa cadastrada !! ");
				System.out.println("");
				break;
			}
			
			for(int i = 0; i< lPessoa.size();i++) {
				System.out.println("Id: " + (i + 1) + " - Nome: " +  lPessoa.get(i).getNome() + " - Perfil: " + lPessoa.get(i).getPerfil());
			}
			
			System.out.println("");
			System.out.println("Qual pessoa deseja deletar ?");
			System.out.println("Digite o Id: ");	
			opc = Reader.readInt();
			opc += -1;
			System.out.println("");
			
			try {
				lPessoa.remove(opc);
				App.linhas();
				System.out.println("");
				System.out.println("Pessoa deletada com sucesso !!");
				System.out.println("");
				break;
			} catch (Exception e) {
				App.linhas();
				System.out.println("");
				System.out.println("Id inválido !!");
				System.out.println("");
				App.linhas();
			}	
			
		}while(true);
		
	}
	
	
	
}
