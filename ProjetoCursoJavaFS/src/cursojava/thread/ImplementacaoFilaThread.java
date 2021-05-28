package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("-----------Fila Rodando----------");


		while (true) {
			
			synchronized (pilha_fila) { /* Bloquear o acesso a esta lista por outros processos */
				
			Iterator iteracao = pilha_fila.iterator();

				while (iteracao.hasNext()) { /* Enquanto tiver dados na lista irá processar */
					
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

					/* Processar 10 mil notas fiscais */
					/* Gerar uma lista enorme de PDFs */
					/* Gerar um envio em massa de e-mails */
					
					System.out.println("--------------------------");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					iteracao.remove();

					try {
						Thread.sleep(1000); /* Dar um tempo para descarga de memória */
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				Thread.sleep(1000); /* Processou toda a lista, dá um tempo para limpeza de memória */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
