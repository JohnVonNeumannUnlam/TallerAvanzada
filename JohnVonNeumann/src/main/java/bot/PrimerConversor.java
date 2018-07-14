package bot;

public class PrimerConversor extends ConversorPadre{

	@Override
	public String convertir(String valor, String unidadInicial, String unidadFinal) {
		return "Disculpa, no identifique alguna de las unidades";
	}

	@Override
	public void setSiguiente(ConversorPadre siguiente) {
		
	}
}
