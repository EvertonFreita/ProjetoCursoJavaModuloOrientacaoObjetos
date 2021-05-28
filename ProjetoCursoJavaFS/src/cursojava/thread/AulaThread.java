package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		/*Thread processando em paralelo*/
		
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();
		
		
		Thread treadNotaFiscal = new Thread(thread2);
		treadNotaFiscal.start();

		/* CÓDIGO DO SISTEMA DO USUÁRIO CONTINUA O FLUXO DE TRABALHO */
		
		System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE  DE THREAD");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário!");
	}
	
	 //----------------------DIVISÃO DAS THREADS-----------------------//
	
	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			for (int pos = 0; pos < 10; pos++) {

				/*
				 * Quero executar esse código com um tempo de parada, ou com um tempo
				 * determinado
				 */
				System.out.println("Executando alguma rotina, por exemplo: envio de e-mail.");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}/*Dá um tempo*/
			}
		}
	};
	
	 //----------------------DIVISÃO DAS THREADS-----------------------//
	
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			/* CÓDIGO DA ROTINA QUE EU QUERO EXECUTAR EM PARALELO */
			for (int pos = 0; pos < 10; pos++) {

				/*
				 * Quero executar esse código com um tempo de parada, ou com um tempo
				 * determinado
				 */
				System.out.println("Executando alguma rotina, por exemplo: envio de nota fiscal.");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}/*Dá um tempo*/
			}
			/* FIM DO CÓDIGO EM PARALELO */
			
		}
	};
}
