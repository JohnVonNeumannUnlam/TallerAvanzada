package bot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bot.ConversorCapacidad;
import bot.ConversorLongitud;
import bot.ConversorMasa;
import bot.ConversorTiempo;

public class SeleccionarConversor extends HandlerConversor  {	
	
	public SeleccionarConversor() {
		patron = Pattern.compile(".*(?:cuántos|cuántas|cuantas|cuantos) (gramos|kilos|onzas|hectogramos|libras|dracmas|kilómetros|kilometros|metros|centimetros|centímetros|pulgadas|pies|yardas|horas|minutos|segundos|mililitros|litros|centilitros|pulgadas cúbicas|pulgadas cubicas|pies cúbicos|pies cubicos|yardas cúbicas|yardas cubicas) (?:son|hay en) ([0-9]+) (gramos|kilos|onzas|hectogramos|libras|dracmas|kilómetros|kilómetros|metros|centimetros|centímetros|pulgadas|pies|yarda|horas|minutos|segundos|mililitros|litros|centilitros|pulgadas cúbicas|pulgadas cubicas|pies cúbicos|pies cubicos|yardas cúbicas|yardas cubicas| gramo|kilo|onza|hectogramo|libra|dracma|kilómetro|kilometro|metro|centimetro|centímetro|pulgada|pie|yard|hora|minuto|segundo|mililitro|litro|centilitro|pulgada cúbica|pulgada cubica|pie cúbico|pie cubico|yarda cúbica|yarda cubica)");
	}
	
	public String giveAnswer(String mensaje, String nombreUsuario) {	    
		Matcher matcher = patron.matcher(mensaje);
		
	    if (matcher.matches()) {	    	
	    	ConversorPadre conversor;	    	
	    	conversor = definirConversor(matcher.group(1));
	    	
	    	if(conversor != null)
	    		return "@" + nombreUsuario + conversor.convertir(matcher.group(1),matcher.group(2),matcher.group(3));
	    	
	    	return "@" + nombreUsuario + " la medida pedida no fue reconocida, lo siento";
	    	
	    }
		return this.nextHandler.giveAnswer(mensaje, nombreUsuario);
	}
	
	public ConversorPadre definirConversor(String unidad){
		switch(unidad){
			case "gramos":
			case "kilos":
			case "onzas":
			case "hectogramos":
			case "libras":
			case "dracmas":			
				return new ConversorMasa();			
			case "kilómetros":
			case "kilometros":
			case "metros":
			case "centimetros":
			case "centímetros":
			case "pulgadas":
			case "pies":
			case "yardas":
				return new ConversorLongitud();			
			case "mililitros":
			case "litros":
			case "centilitros":
			case "pulgadas cúbicas":
			case "pulgadas cubicas":
			case "pies cúbicos":
			case "pies cubicos":
			case "yardas cúbicas":
			case "yardas cubicas":
				return new ConversorCapacidad();			
			case "horas":
			case "minutos":
			case "segundos":
				return new ConversorTiempo();			
		}
		
		return null;
	}

}
