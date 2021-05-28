package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Pessoa;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Everton Freitas");
		aluno.setNomeEscola("JdevTreinamento");
		aluno.setIdade(25);
		
		Diretor diretor = new Diretor();
		diretor.setNome("Jos�");
		diretor.setRegistroEducacao("56gsqyduywevf7");
		diretor.setIdade(10);
		
		Secretario secretario = new Secretario();
		secretario.setNome("Zezim");
		secretario.setNivelCargo("secret�rio");
		secretario.setIdade(20);
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		
		System.out.println(aluno.msgMaiorIdade());
		
		System.out.println("O sal�rio do aluno �: " + aluno.salario());
		System.out.println("O sal�rio do diretor �: " + diretor.salario());
		System.out.println("O sal�rio do secretario �: " + secretario.salario());
		
		Pessoa pessoa = new Aluno();
		pessoa = secretario;
		pessoa = diretor;

		teste(aluno);
		teste(diretor);
		teste(secretario);
	}
	
	public static void teste(Pessoa pessoa) {
		System.out.println("Essa pessoa � demais = " + pessoa.getNome() + " e o sal�rio � = " + pessoa.salario());
	}

}
