package guerra;

public class Herido implements EstadoSoldado {
	private final static String HERIDO = "Herido";

	@Override
	public void recibirDisparo(Soldado soldado) {
		soldado.setCantAgujeros(1);
		soldado.setCm3(100);
		soldado.setEstado(new Muerto());

	}

	@Override
	public void recibirCuracion(Soldado soldado) {
		soldado.setCantAgujeros(-1);
		soldado.setEstado(new Saludable());

	}

	@Override
	public String informarEstado() {
		return HERIDO;
	}

}
