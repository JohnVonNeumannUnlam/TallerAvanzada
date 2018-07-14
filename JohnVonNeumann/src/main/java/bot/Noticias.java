package bot;

public class Noticias {

	public static String noticiasGeneral() throws Exception{
		
		String ciudad = Jsonapis.obtenerCiudad();
		StringBuilder sb = new StringBuilder();
		
		sb.append(Jsonapis.temperatura(ciudad)+"\n\n");
		sb.append(Fecha.hora()+"\n\n");
		sb.append(Jsonapis.obtenerDolar()+"\n");
		sb.append("---NOTICIAS---\n\n");
		sb.append(Jsonapis.obtenerNoticias());
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(Noticias.noticiasGeneral());
	}
	
}
