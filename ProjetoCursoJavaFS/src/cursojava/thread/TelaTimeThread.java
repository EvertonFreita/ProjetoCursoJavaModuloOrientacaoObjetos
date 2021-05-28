package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout()); /* Painel de componente */

	private JLabel descricaoNome = new JLabel("Nome");

	private JTextField nomeText = new JTextField();

	private JLabel descricaoMail = new JLabel("E-mail");

	private JTextField nomeText2 = new JTextField();

	private JButton jbuttonStart = new JButton("Gerar dados");

	private JButton jbuttonStop = new JButton("Stop");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaTimeThread() { /* Executa oque estiver dentro da abertura ou execução */

		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		/* Primeira parte concluida */

		GridBagConstraints gridBagConstraints = new GridBagConstraints(); /*
																			 * Controlador de posicionamento de
																			 * componenetes
																			 */

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.CENTER;

		descricaoNome.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoNome, gridBagConstraints);

		nomeText.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(nomeText, gridBagConstraints);

		descricaoMail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(descricaoMail, gridBagConstraints);

		nomeText2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(nomeText2, gridBagConstraints);

		// =====================================

		gridBagConstraints.gridwidth = 1;
		jbuttonStart.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jpanel.add(jbuttonStart, gridBagConstraints);

		jbuttonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jpanel.add(jbuttonStop, gridBagConstraints);

		jbuttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();		
				}
				
				for (int qtd = 0; qtd < 10; qtd++) {
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(nomeText.getText());
					filaThread.setEmail(nomeText2.getText() + " - " + qtd);

					fila.add(filaThread);
				}
			}
		});

		jbuttonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
		});

		fila.start();
		add(jpanel, BorderLayout.CENTER);

		/* Sempre será o último comando */
		setVisible(true); /* Torna a tela visivel para o usuário */
	}
}
