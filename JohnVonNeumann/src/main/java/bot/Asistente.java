package bot;

public class Asistente {
	
	String nombreAsistente;
	
	public Asistente(String nombreAsistente) {
		this.nombreAsistente = nombreAsistente;
	}


	public String devolverAgradecimiento(String entrada, String userName) {
		
		String[] palabras = {"gracias", "muchas gracias", "te agradezco", "muy amable"};
		for(int i = 0; i < palabras.length; i++){
			
			if(entrada.toLowerCase().contains(palabras[i])) {
				
				return "¡De nada, @"+ userName + "!";   /*Luego puede devolver una respuesta random*/
			}
		}
		return "";
	}
	
	
	public String devolverSaludo(String entrada, String userName) {
		
		String[] palabras = {"hola", "buen dia", "buenas", "hey"};
		for(int i = 0; i < palabras.length; i++){
			
			if(entrada.toLowerCase().contains(palabras[i])) {
				
				return "¡Hola, @"+ userName + "!";   /*Luego puede devolver una respuesta random*/
			}
		}
		return "";
		
	}


}
