package test;

import org.junit.*;

import guerra.Soldado;

public class SoldadoTest {

	Soldado soldado = new Soldado();

	public String mostrar() {
		return soldado.getCantAgujeros() + " " + soldado.getCm3() + " " + soldado.informarEstado();
	}

	@Test
	public void soldadoEstado() {

		Assert.assertEquals("0 4500 Saludable", mostrar());

		soldado.recibirCuracion(soldado);
		Assert.assertEquals("0 4500 Saludable", mostrar());

		soldado.recibirDisparo(soldado);
		Assert.assertEquals("1 4400 Herido", mostrar());

		soldado.recibirCuracion(soldado);
		Assert.assertEquals("0 4400 Saludable", mostrar());

		soldado.recibirDisparo(soldado);
		Assert.assertEquals("1 4300 Herido", mostrar());

		soldado.recibirDisparo(soldado);
		Assert.assertEquals("2 4200 Muerto", mostrar());

		soldado.recibirCuracion(soldado);
		Assert.assertEquals("0 4500 Saludable", mostrar());

	}

}
