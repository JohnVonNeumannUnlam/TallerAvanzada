package bot;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conversor {

	private ConversorPadre primero;

	private ConversorMasa aMasa = new ConversorMasa();
	private ConversorTiempo aTiempo = new ConversorTiempo();
	private ConversorLongitud aLongitud = new ConversorLongitud();
	private ConversorCapacidad aCapacidad = new ConversorCapacidad();

	public Conversor() {
		aCapacidad.setSiguiente(new PrimerConversor());
		aLongitud.setSiguiente(aCapacidad);
		aTiempo.setSiguiente(aLongitud);
		aMasa.setSiguiente(aTiempo);

		this.primero = aMasa;
	}

	public String convertir(String valor, String unidadInicial, String unidadFinal) {
		String cambio;
		String respuesta = " ";

		cambio = this.primero.convertir(valor, plural(unidadInicial), unidadFinal); 

		if (cambio.contains(" "))
			return respuesta + respuesta;

		respuesta += valor + " " + unidadInicial + (valor.equals("1") ? " equivale a " : " equivalen a ");

		cambio = redondearNumero(cambio);

		return respuesta + cambio + " " + (cambio.equals("1") ? singular(unidadFinal) : unidadFinal);
	}

	String plural(String singular) {

		String[] palabras = singular.split(" ");

		if (palabras.length > 1)
			return plural(palabras[0]) + " " + plural(palabras[1]);

		if (!singular.endsWith("s") || singular.equals("mes"))
			return !singular.equals("galon") && !singular.equals("barril") && !singular.equals("ston")
					&& !singular.equals("mes") ? singular.concat("s") : singular.concat("es");

		return singular;
	}

	String singular(String plural) {
		if (plural.endsWith("s"))
			return plural.endsWith("es") ? plural.substring(0, plural.length() - 2)
					: plural.substring(0, plural.length() - 1);

		return plural;
	}

	String redondearNumero(String valor) {

		BigDecimal numero = new BigDecimal(valor);
		BigDecimal parteEntera = new BigDecimal(numero.toBigInteger());
		BigDecimal parteDecimal = numero.remainder(BigDecimal.ONE);

		if (parteDecimal.equals(BigDecimal.valueOf(0.0)) || parteDecimal.equals(BigDecimal.valueOf(0)))
			return parteEntera.toString();
		else {
			String redondeo = numero.setScale(2, RoundingMode.HALF_DOWN).toString();

			if (redondeo.endsWith("0"))
				redondeo = numero.setScale(1, RoundingMode.HALF_DOWN).toString();

			if (redondeo.endsWith("0"))
				redondeo = numero.setScale(0, RoundingMode.HALF_DOWN).toString();

			return redondeo;
		}
	}
}
