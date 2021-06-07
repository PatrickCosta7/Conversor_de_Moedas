package br.com.costa7.conv.logic;

import java.util.ArrayList;
import java.util.List;

public class Processamento {

	private final List<RetornoResultado> observer = new ArrayList<>();
	private static final Processamento instancia = new Processamento();
	public String valor2;
	public static String valor1;
	public static String currency1;
	public static String currency2;

	private Processamento() {

	}

	public static Processamento getInstancia() {
		return instancia;
	}

	public void registrarObserver(RetornoResultado observador) {
		observer.add(observador);

	}

	public void calculoMoeda() {

		if (currency1.equals("Dollar")) {
			dollar();
		} else if (currency1.equals("Real")) {
			real();
		} else if (currency1.equals("Peso Argentino")) {
			peso();
		} else if (currency1.equals("Euro")) {
			euro();
		} else {
			return;
		}

		observer.forEach(o -> o.resultado(valor2));
	}

	private void euro() {
		Double valorM = Double.parseDouble(valor1.replace(",", "."));
		Double resultado = 0.0;

		if (currency2.equalsIgnoreCase("Euro")) {
			resultado = valorM * 1;
		} else if (currency2.equalsIgnoreCase("Dollar")) {
			resultado = valorM * 1.22;
		} else if (currency2.equalsIgnoreCase("Peso Argentino")) {
			resultado = valorM * 115.22;
		} else if (currency2.equalsIgnoreCase("Real")) {
			resultado = valorM * 6.48;
		}
		
		resultado = (double) (Math.round(resultado * 100.0) / 100.0);
		valor2 = Double.toString(resultado).replace(".", ",");

	}

	private void peso() {
		Double valorM = Double.parseDouble(valor1.replace(",", "."));
		Double resultado = 0.0;

		if (currency2.equalsIgnoreCase("Euro")) {
			resultado = valorM * 0.0087;
		} else if (currency2.equalsIgnoreCase("Dollar")) {
			resultado = valorM * 0.011;
		} else if (currency2.equalsIgnoreCase("Peso Argentino")) {
			resultado = valorM * 1;
		} else if (currency2.equalsIgnoreCase("Real")) {
			resultado = valorM * 0.056;
		}
		
		resultado = (double) (Math.round(resultado * 100.0) / 100.0);
		valor2 = Double.toString(resultado).replace(".", ",");

	}

	private void real() {
		Double valorM = Double.parseDouble(valor1.replace(",", "."));
		Double resultado = 0.0;

		if (currency2.equalsIgnoreCase("Euro")) {
			resultado = valorM * 0.15;
		} else if (currency2.equalsIgnoreCase("Dollar")) {
			resultado = valorM * 0.19;
		} else if (currency2.equalsIgnoreCase("Peso Argentino")) {
			resultado = valorM * 17.79;
		} else if (currency2.equalsIgnoreCase("Real")) {
			resultado = valorM * 1;
		}
		
		resultado = (double) (Math.round(resultado * 100.0) / 100.0);
		valor2 = Double.toString(resultado).replace(".", ",");

	}

	private void dollar() {
		Double valorM = Double.parseDouble(valor1.replace(",", "."));
		Double resultado = null;
		
		if (currency2.equalsIgnoreCase("Euro")) {
			resultado = valorM*0.87;
		} else if(currency2.equalsIgnoreCase("Dollar")) {
			resultado = valorM*1;
		} else if(currency2.equalsIgnoreCase("Peso Argentino")) {
			resultado = valorM*94.48;
		} else if(currency2.equalsIgnoreCase("Real")) {
			resultado = valorM*5.31;
		}
		
		resultado = (double) (Math.round(resultado * 100.0) / 100.0);
		valor2 = Double.toString(resultado).replace(".", ",");
		
	}

}
