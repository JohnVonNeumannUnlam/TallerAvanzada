package guerra;

public class Saludable implements EstadoSoldado {

	private final static String SALUDABLE = "Saludable";

	@Override
	public void recibirDisparo(Soldado soldado) {

		soldado.setCantAgujeros(1);
		soldado.setCm3(100);
		soldado.setEstado(new Herido());

	}

	@Override
	public void recibirCuracion(Soldado soldado) {

		
	}

	@Override
	public String informarEstado() {
		return SALUDABLE;

	}

}
