package cursojava.executavel;

public class Matriz {

	public static void main(String[] args) {
		int notas[][] = new int[2][3];
		
		notas[0][0]= 78;
		notas[0][1]= 89;
		notas[0][2]= 90;
		
		notas[1][0]= 98;
		notas[1][1]= 95;
		notas[1][2]= 97;
		
		/*Percorre linhas*/
		for(int poslinha = 0; poslinha < notas.length; poslinha++) {
			System.out.println("==============================================");
			/*Percorre as colunas*/
			for(int poscoluna = 0; poscoluna < notas[poslinha].length; poscoluna++) {
				System.out.println("Valor da matriz: " + notas[poslinha][poscoluna]);
			}
		}
		
	}
}
