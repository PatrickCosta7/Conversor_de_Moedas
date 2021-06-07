package br.com.costa7.conv.interfaceConversor;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Conversor extends JFrame {

	Display painel;

	public Conversor() {

		painel = new Display();

		add(painel);
		pack(); // quando o tamanho da janela for dado pela instância, esse método deve ser
				// colocado.

		setTitle("Conversor de moedas");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		new Conversor();
	}

}
