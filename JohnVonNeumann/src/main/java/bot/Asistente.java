package bot;

public class Asistente {
	
	String nombreAsistente;
	
	public String devolverAgradecimiento(String entrada) {
		
		String[] palabras = {"gracias", "muchas gracias", "te agradezco", "muy amable"};
		for(int i = 0; i < palabras.length; i++){
			
			if(entrada.toLowerCase().contains(palabras[i])) {
				
				return "De nada!";   /*Luego puede devolver una respuesta random*/
			}
		}
		return "";
	}
	
	
	public String devolverSaludo(String entrada) {
		
		String[] palabras = {"hola", "buen dia", "buenas", "hey"};
		for(int i = 0; i < palabras.length; i++){
			
			if(entrada.toLowerCase().contains(palabras[i])) {
				
				return "Hola, UserX!";   /*Luego puede devolver una respuesta random*/
			}
		}
		return "";
		
	}


}
