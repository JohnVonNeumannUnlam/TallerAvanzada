package guerra;

public class Muerto implements EstadoSoldado {
	private final static String MUERTO = "Muerto";
	private static int VIDA_BASE = 4500;
	private static int SANO = 0;

	@Override
	public void recibirDisparo(Soldado soldado) {
		soldado.setCantAgujeros(1);

	}

	@Override
	public void recibirCuracion(Soldado soldado) {
		int n;
		if ((n = soldado.getCm3()) < VIDA_BASE) {
			soldado.setCm3(n - VIDA_BASE);
		}
		
		if((n = soldado.getCantAgujeros()) > SANO ) {
			soldado.setCantAgujeros(SANO - n);
		}
			
		soldado.setEstado(new Saludable());
	}

	@Override
	public String informarEstado() {

		return MUERTO;
	}

}
