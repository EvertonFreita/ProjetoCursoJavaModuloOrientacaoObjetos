package cursojava.executavel;

import java.util.ArrayList;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {

	public static void main(String[] args) {
		
		double[] notas = {8.9,7.0,6.8,9.9};
		double[] notasLogica = {7.9,9.9,6.9,10.0};
		
		/*Criação de alunos*/
		Aluno aluno = new Aluno();
		aluno.setNome("Everton Freitas");
		aluno.setNomeEscola("Jdev treinamento");
		
		/*Criação de disciplina*/
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Curso de java");
		disciplina.setNota(notas);
		
		aluno.getDisciplinas().add(disciplina);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Lógica de programação");
		disciplina2.setNota(notasLogica);
		
		aluno.getDisciplinas().add(disciplina2);
		
		/*Criação de alunos*/
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Joaquim de Freitas");
		aluno2.setNomeEscola("Jdev treinamento");
		
		/*Criação de disciplina*/
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("Hibernate");
		disciplina3.setNota(notas);
		
		aluno2.getDisciplinas().add(disciplina3);
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setDisciplina("Angular");
		disciplina4.setNota(notasLogica);
		
		aluno2.getDisciplinas().add(disciplina4);
		
		//--------------------------------------------
		
		Aluno[] arrayAlunos = new Aluno [2];
		arrayAlunos[0] = aluno;
		arrayAlunos[1] = aluno2;
		
		for(int pos = 0; pos < arrayAlunos.length; pos++) {
			System.out.println("Nome do aluno é: " + arrayAlunos[pos].getNome());
			
			for(Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				System.out.println("Nome da disciplina: " + d.getDisciplina());
				
				for(int posN = 0; posN < d.getNota().length; posN++) {
					System.out.println("A nota " + (posN + 1) + " : " + d.getNota()[posN]);
				}
			}
		}
		
	}
}
