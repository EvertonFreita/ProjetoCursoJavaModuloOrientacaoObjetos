package cursojava.excecao;

public class ExcecaoProcessarNota extends Exception {

	public ExcecaoProcessarNota(String erro) {
		super("Vixx erro ao procesar a nota do aluno" + erro);
	}
}
