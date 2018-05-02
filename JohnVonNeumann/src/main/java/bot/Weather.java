package bot;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import net.aksingh.owmjapis.*;

public class Weather {
	
	public static String temperatura(String city) {
	    String ret = new String();
		boolean isMetric = true;
	    String owmApiKey = "3a7935bcb1178cede69ad833c05e37b8";
	    String weatherCity = city;
	    OpenWeatherMap.Units units = (isMetric)
	        ? OpenWeatherMap.Units.METRIC
	        : OpenWeatherMap.Units.IMPERIAL;
	    OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
	    try {
	      CurrentWeather weather = owm.currentWeatherByCityName(weatherCity);
	      JSONObject clima = new JSONObject(weather.getRawResponse());
	      //System.out.println("La temperatura para " + weather.getCityName() + " es de " + clima.getJSONObject("main").getDouble("temp") + "°C");
	      ret = "La temperatura para " + weather.getCityName() + " es de " + clima.getJSONObject("main").getDouble("temp") + "°C";
	    }
	    catch (IOException | JSONException e) {
	      e.printStackTrace();
	    }
	    return ret;
	}
}
	
