package bot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AsistenteTest {
	
	public final static String USER = "Jorge";
	Asistente robot;
	
	@Before
	public void setup() {
		robot = new Asistente("robotitus");
	}
	
	@Test
	public void ejercicio0(){
			System.out.println(robot.enviar(USER,"wea cosmica"));
			Assert.assertTrue(robot.enviar(USER,"wea cosmica").contains("No entendi"));
	}
	
	@Test
	public void ejercicio1() {
		
		String[] mensajes = {
				"hola!",
				"hola padre, como andas"
		};

			
		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("Buen dia"));
		}
		
	}
	
	@Test
	public void ejercicio2() {
		
		String[] mensajes = {
				"gracias, te agradezco mucho por lo que hiciste!",
				"GRAciaS!"
		};

		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("De nada"));
		}
		
	}
	
	@Test
	public void ejercicio2plus() {
		
		String[] mensajes = {
				"los chause"
		};

			
		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("Goodbye"));
		}
		
	}
	
	@Test
	public void ejercicio3() {
		
		System.out.println(robot.enviar(USER,"que hora es?"));
		Assert.assertTrue(robot.enviar(USER,"que hora es?").contains("Son las"));
		
		System.out.println(robot.enviar(USER,"que dia es?"));
		Assert.assertTrue(robot.enviar(USER,"que dia es?").contains("Hoy es"));
		
		System.out.println(robot.enviar(USER,"qu� d�a es?"));
		Assert.assertTrue(robot.enviar(USER,"qu� d�a es?").contains("Hoy es"));
		
		System.out.println(robot.enviar(USER,"quisiera saber la fecha actual"));
		Assert.assertTrue(robot.enviar(USER,"quisiera saber la fecha actual").contains("Hoy es"));
		
		System.out.println(robot.enviar(USER,"que dia de la semana es?"));
		Assert.assertTrue(robot.enviar(USER,"que dia de la semana es?").contains("Hoy es"));
				
	}
	
	@Test
	public void ejercicio4() {
		
		System.out.println(robot.enviar(USER,"que d�a ser� en 4 dias?"));
		Assert.assertTrue(robot.enviar(USER,"que d�a ser� en 4 dias?").contains("Sera el"));
		
		System.out.println(robot.enviar(USER,"que dia sera en 27 a�os"));
		Assert.assertTrue(robot.enviar(USER,"que dia sera en 27 a�os").contains("Sera el"));
		
		System.out.println(robot.enviar(USER,"que dia fue hace 4 dias"));
		Assert.assertTrue(robot.enviar(USER,"que dia fue hace 4 dias").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que dia fue ayer???"));
		Assert.assertTrue(robot.enviar(USER,"que dia fue ayer???").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que dia fue anteayer"));
		Assert.assertTrue(robot.enviar(USER,"que dia fue anteayer").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que d�a fu� antes de ayer"));
		Assert.assertTrue(robot.enviar(USER,"que d�a fu� antes de ayer").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que dia sera ma�ana?????"));
		Assert.assertTrue(robot.enviar(USER,"que dia sera ma�ana?????").contains("Sera el"));
		
		System.out.println(robot.enviar(USER,"cu�ntos d�as pasaron desde el 1 de abril de 2017?"));
		Assert.assertTrue(robot.enviar(USER,"cu�ntos d�as pasaron desde el 1 de abril de 2017?").contains("Paso"));
		
		System.out.println(robot.enviar(USER,"cuantos dias faltan para el 4 de septiembre de 2018??"));
		Assert.assertTrue(robot.enviar(USER,"cuantos dias faltan para el 4 de septiembre de 2018??").contains("Falta"));
		
		System.out.println(robot.enviar(USER,"cu�ntos meses pasaron desde el 1 de abril de 2017?"));
		Assert.assertTrue(robot.enviar(USER,"cu�ntos meses pasaron desde el 1 de abril de 2017?").contains("Paso"));
		
		System.out.println(robot.enviar(USER,"cuantos meses faltan para el 4 de septiembre de 2018??"));
		Assert.assertTrue(robot.enviar(USER,"cuantos meses faltan para el 4 de septiembre de 2018??").contains("Falta"));
		
		System.out.println(robot.enviar(USER,"cu�ntos a�os pasaron desde el 1 de abril de 2017?"));
		Assert.assertTrue(robot.enviar(USER,"cu�ntos a�os pasaron desde el 1 de abril de 2017?").contains("Paso"));
		
		System.out.println(robot.enviar(USER,"cuantos a�os faltan para el 4 de septiembre de 2023??"));
		Assert.assertTrue(robot.enviar(USER,"cuantos a�os faltan para el 4 de septiembre de 2023??").contains("Falta"));
		
//		"cuantos dias faltan para el 8 de agosto??"
		
		
	}
	
	@Test
	public void ejercicio9() {
		
		System.out.println(robot.enviar(USER,"quiero saber el clima en merlo"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima en merlo").contains("La temperatura"));
		
		System.out.println(robot.enviar(USER,"quiero saber el clima en san justo"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima en san justo").contains("La temperatura"));
				
	}
	
	@Test
	public void ejercicioChuck() {
		
		System.out.println(robot.enviar(USER,"quiero un chuck norris fact"));
		Assert.assertTrue(robot.enviar(USER,"quiero un chuck norris fact").contains("Chuck Norris"));
		
		System.out.println(robot.enviar(USER,"quiero un chuck norris fact"));
		Assert.assertTrue(robot.enviar(USER,"quiero un chuck norris fact").contains("Chuck Norris"));
		
		System.out.println(robot.enviar(USER,"quiero un chuck norris fact"));
		Assert.assertTrue(robot.enviar(USER,"quiero un chuck norris fact").contains("Chuck Norris"));
				
	}
	
	@Test
	public void ejercicioRobotica() {
		
		System.out.println(robot.enviar(USER,"quiero la primera ley de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero la primera ley de la robotica please").contains("1- Un robot"));
		
		System.out.println(robot.enviar(USER,"quiero la 2da ley de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero la 2da ley de la robotica please").contains("2- Un robot"));
		
		System.out.println(robot.enviar(USER,"quiero la tercera ley de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero la tercera ley de la robotica please").contains("3- Un robot"));
		
		System.out.println(robot.enviar(USER,"quiero todas las leyes de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero todas las leyes de la robotica please").contains("1- Un robot"));
				
	}
	
	
}
