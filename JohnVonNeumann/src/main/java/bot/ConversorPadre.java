package bot;

import java.util.Map;

public abstract class ConversorPadre {

	public abstract void setSiguiente(ConversorPadre siguiente);

	public String convertir(String valor, String unidadInicial, String unidadFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String cambioDeUnidad(Map<String, Double> unidades, double valor, String unidadInicial, String unidadFinal, ConversorPadre siguiente) {
		
		if (unidades.containsKey(unidadInicial) && unidades.containsKey(unidadFinal)) 
			return String.valueOf(valor * (unidades.get(unidadInicial) / unidades.get(unidadFinal)));
		else
			return siguiente.convertir(String.valueOf(valor), unidadInicial, unidadFinal);
	}

}
