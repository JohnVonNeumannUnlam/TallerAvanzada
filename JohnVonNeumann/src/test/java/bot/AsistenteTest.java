package bot;

import org.junit.Assert;
import org.junit.Test;

public class AsistenteTest {
	
	public final static String USUARIO = "fns92";
	
	@Test
	public void devuelveElAgradecimiento() {
		
		String[] mensajes = {
				"¡Muchas gracias!!",
				"te agradezco mucho por lo que hiciste!",
				"GRAciaS!",
				"Simplemente gracias por todo lo que haces cada dia.",
				"En fin. Muchisimas Gracias por todo."
		};

		Asistente xerox = new Asistente("Xerox");
		
		for(String mensaje : mensajes) {
			
			Assert.assertEquals("¡De nada, @fns92!", xerox.devolverAgradecimiento(mensaje, USUARIO));
		}
}
		
		@Test
		public void devuelveElSaludo() {
			
			String[] mensajes1 = {
					"¡Hola, @botMan!",
					"@botMan hola!",
					"buen dia @jenkins",
					"@botMan, buenas tardes",
					"hey @botMan"
			};
			
			Asistente botMan = new Asistente("botMan");
			
			for(String mensaje : mensajes1) {
				
				Assert.assertEquals("¡Hola, @fns92!", botMan.devolverSaludo(mensaje, USUARIO));
			}
		}
		
	}
