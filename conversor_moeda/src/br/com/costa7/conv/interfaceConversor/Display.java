package br.com.costa7.conv.interfaceConversor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.costa7.conv.logic.Processamento;
import br.com.costa7.conv.logic.RetornoResultado;

@SuppressWarnings("serial")
public class Display extends JPanel implements ActionListener, RetornoResultado {
	
	
	JComboBox<String> currency1;
	JComboBox<String> currency2;
	JFormattedTextField valor1;
	JTextField valor2;
	JButton botaoCalcular;
	String[] moedas = { "Dollar", "Real", "Peso Argentino", "Euro" };
	

	public Display() {
		Processamento.getInstancia().registrarObserver(this);
		NumberFormat x = DecimalFormat.getInstance();
		x.setMinimumFractionDigits(2);
		x.setMaximumFractionDigits(2);
		x.setRoundingMode(RoundingMode.HALF_UP);
		
		valor1 = new JFormattedTextField(x);
		valor1.setFont(new Font("courier", Font.PLAIN, 12));
		valor1.setBorder(BorderFactory.createEmptyBorder());
		valor1.setBounds(20, 50, 150, 30);

		
		currency1 = new JComboBox<String>(moedas);
		currency1.setBounds(20, 10, 150, 30);
		currency1.setFont(new Font("courier", Font.PLAIN, 15));
		currency1.setBorder(BorderFactory.createEmptyBorder());
		
		currency2 = new JComboBox<String>(moedas);
		currency2.setBounds(200, 10, 150, 30); //set bound somente funciona quando o LayoutManager é null
		currency2.setFont(new Font("courier", Font.PLAIN, 15));
		currency2.setBorder(BorderFactory.createEmptyBorder());
		
		valor2 = new JTextField();
		valor2.setFont(new Font("courier", Font.PLAIN, 12));
		valor2.setBorder(BorderFactory.createEmptyBorder());
		valor2.setBounds(200, 50, 150, 30);
		valor2.setEditable(false);
		
		botaoCalcular = new JButton();
		botaoCalcular.setText("Calcular");
		botaoCalcular.setFont(new Font("courier", Font.PLAIN, 15));
		botaoCalcular.setBackground(new Color(172, 172, 172));
		botaoCalcular.setBorder(BorderFactory.createEmptyBorder());
		botaoCalcular.setBounds(370, 10 , 110, 70);
		botaoCalcular.addActionListener(this);
		
		add(valor1);
		add(valor2);
		add(currency1);
		add(currency2);
		add(botaoCalcular);
		setLayout(null);
		setPreferredSize(new Dimension(500, 110));
		setBackground(new Color(70, 70, 70));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botaoCalcular) {
			
			Processamento.getInstancia();
			Processamento.currency1 = (String) currency1.getSelectedItem();
			Processamento.currency2 = (String) currency2.getSelectedItem();
			Processamento.valor1 = valor1.getText();
			
			Processamento.getInstancia().calculoMoeda();;
		}

	}
	
	@Override
	public void resultado(String Resultado) {
		valor2.setText(Resultado);
		
	}

}
