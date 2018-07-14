package bot;

import org.junit.*;

import org.junit.jupiter.api.Test;

class WeatherTest {

	@Test
	void necochea() {
		System.out.println(Jsonapis.temperatura("necochea"));
		Assert.assertTrue(true);
	}
	
	@Test
	void merlo() {
		System.out.println(Jsonapis.temperatura("merlo,AR"));
		Assert.assertTrue(true);
	}

}
