package guerra;

public class Soldado {

	private static int CM3 = 4500;
	private static int CANT_AGUJEROS = 0;
	private EstadoSoldado estado;

	public Soldado() {

		this.estado = new Saludable();
	}

	public int getCm3() {
		return CM3;
	}

	public void setCm3(int cm3) {
		CM3 -= cm3;
	}

	public int getCantAgujeros() {
		return CANT_AGUJEROS;
	}

	public void setCantAgujeros(int cantAgujeros) {
		CANT_AGUJEROS += cantAgujeros;
	}

	public EstadoSoldado getEstado() {
		return estado;
	}

	public void setEstado(EstadoSoldado estado) {
		this.estado = estado;
	}

	public void recibirDisparo(Soldado soldado) {

		estado.recibirDisparo(soldado);

	}

	public void recibirCuracion(Soldado soldado) {
		estado.recibirCuracion(soldado);
	}

	public String informarEstado() {

		return estado.informarEstado();
	}

}
