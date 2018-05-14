package guerra;

public interface EstadoSoldado {
	
	public void recibirDisparo(Soldado soldado);
	public void recibirCuracion(Soldado soldado);
	public String informarEstado();
	
}
