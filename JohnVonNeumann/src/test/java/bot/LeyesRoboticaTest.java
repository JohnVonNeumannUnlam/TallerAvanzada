package bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


public class LeyesRoboticaTest {

	@Test
	public void respuestaLeyes() {
		
		assertTrue(LeyesRobotica.PrimeraLey().equals("1- Un robot no har� da�o a un ser humano, ni permitir� con su inacci�n que sufra da�o."));
		assertTrue(LeyesRobotica.SegundaLey().equals("2- Un robot debe cumplir las �rdenes dadas por los seres humanos, a excepci�n de aquellas que entrasen en conflicto con la primera ley."));
		assertTrue(LeyesRobotica.TerceraLey().equals("3- Un robot debe proteger su propia existencia en la medida en que esta protecci�n no entre en conflicto con la primera o con la segunda ley."));
		
		assertTrue(LeyesRobotica.LeyAll().equals("1- Un robot no har� da�o a un ser humano, ni permitir� con su inacci�n que sufra da�o.\n" +
				"2- Un robot debe cumplir las �rdenes dadas por los seres humanos, a excepci�n de aquellas que entrasen en conflicto con la primera ley.\n" + 
				"3- Un robot debe proteger su propia existencia en la medida en que esta protecci�n no entre en conflicto con la primera o con la segunda ley."));
	}
	
}
