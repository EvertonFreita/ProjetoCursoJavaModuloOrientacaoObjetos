package cursojava.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;

public class PrimeiraClasseJava {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		
		try {
			

			
		String login = JOptionPane.showInputDialog("Informe o login: ");
		String senha = JOptionPane.showInputDialog("Informe a senha: ");
		
		
		if(new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {
			
			
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		/*É uma lista que dentro dela temos uma chave que identifica uma sequencia de valores também*/
		HashMap<String, List<Aluno>> maps =  new HashMap<String, List<Aluno>>();
		
		
		for (int qtd = 1; qtd <= 1; qtd++) {

			String nome = JOptionPane.showInputDialog("Qual é o nome do aluno " + qtd + " ?");
			 String idade = JOptionPane.showInputDialog("Qual é a idade do aluno?");
			/*
			 *
			 * String dataNascimento = JOptionPane.showInputDialog("Qual é a data de nascimento do aluno?"); 
			 * String rg = JOptionPane.showInputDialog("Qual é o registro geral do aluno?"); 
			 * String cpf = JOptionPane.showInputDialog("Qual é o CPF do aluno?"); 
			 * String mae = JOptionPane.showInputDialog("Qual é o nome da mãe do aluno?");
			 * String pai = JOptionPane.showInputDialog("Qual é o nome do pai do aluno?"); String
			 * matricula = JOptionPane.showInputDialog("Qual é a data da matrícula do aluno?");
			 * String escola = JOptionPane.showInputDialog("Qual é o nome da escola do aluno?");
			 * String serie = JOptionPane.showInputDialog("Qual é a série em que o aluno está matriculado?"); 
		     */
			  
			
			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
		    aluno1.setIdade(Integer.valueOf(idade));
			/*
			 *
			 * aluno1.setDataNascimento(dataNascimento); 
			 * aluno1.setRegistroGeral(rg);
			 * aluno1.setNumeroCpf(cpf);
			 * aluno1.setNomeMae(mae); 
			 * aluno1.setNomePai(pai);
			 * aluno1.setDataMatricula(matricula); 
			 * aluno1.setNomeEscola(escola);
			 * aluno1.setSerieMatriculado(serie);
			 */

			for (int pos = 1; pos <= 1; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
				String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				//disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);
			}

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");

			if (escolha == 0) {
				int continuarRemover = 0;
				int posicao = 1;

				while (continuarRemover == 0) {

					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4? ");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover? ");
				}
			}

			alunos.add(aluno1);
		}
		
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		
		for (Aluno aluno : alunos) {/*Separei em listas*/
			
			if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);
			}
			else if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);
			}
			else if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
				maps.get(StatusAluno.REPROVADO).add(aluno);
			}
		}
		
	    System.out.println("--------------------- Lista dos Aprovados ---------------------------");
	    for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
	    	System.out.println(aluno.getNome());
			System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média = " + aluno.getMediaNota());
		}
	    
	    System.out.println("--------------------- Lista dos Reprovados ---------------------------");
	    
	    for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
	    	System.out.println(aluno.getNome());
			System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média = " + aluno.getMediaNota());
		}
	    
	    System.out.println("--------------------- Lista de Recuperação ---------------------------");
	    for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
	    	System.out.println(aluno.getNome());
			System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média = " + aluno.getMediaNota());
		}

      }
		else {
			JOptionPane.showMessageDialog( null, "Dados incorretos");
		}
		
	  }catch (Exception e) {  /* aqui*/
		//e.printStackTrace();
		
		StringBuilder saida = new StringBuilder();
		
		System.out.println("Mensagem: " + e.getMessage());
		
		for(int pos = 0; pos < e.getStackTrace().length ; pos++) {
			
			saida.append("\n Classe de erro: " + e.getStackTrace()[pos].getClassName());
			saida.append("\n Método de erro: " + e.getStackTrace()[pos].getMethodName());
			saida.append("\n Linha de erro: " + e.getStackTrace()[pos].getLineNumber());
			saida.append("\n Class: " + e.getClass().getName());
		}
		
		JOptionPane.showMessageDialog(null, "Erro ao processar notas: " + saida.toString());
		
	}
		finally {/*Sempre é sempre executado ocorrendo erros ou não*/
			/*O finally sempre é usado quando precisa executar um processo acontecendo erro ou não no sistema*/
		JOptionPane.showMessageDialog(null, "Obrigado por aprender java comigo");
	}
   }

}
