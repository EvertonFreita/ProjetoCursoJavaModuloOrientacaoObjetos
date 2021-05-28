package cursojava.classes;

import java.util.Arrays;

public class Disciplina {

	/*Cada disciplina terá 4 notas durante o ano inteiro*/
	private String disciplina;
	private double [] nota = new double[4];

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public double[] getNota() {
		return nota;
	}

	public void setNota(double[] nota) {
		this.nota = nota;
	}
	
	/*Método que retorna a média do aluno*/
	public double getMediaNota() {
		double somaTotal = 0.0;
		for(int pos = 0; pos < nota.length; pos++) {
			somaTotal += nota[pos];
		}
		return somaTotal / 4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + Arrays.hashCode(nota);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (!Arrays.equals(nota, other.nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [disciplina=" + disciplina + ", nota=" + nota + "]";
	}

}
