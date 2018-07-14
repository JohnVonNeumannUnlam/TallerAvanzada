package bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Wikipedia {

	private static final String encoding = "UTF-8";

	public static String buscarInfo(String mensaje) {
		String textToTell = null;
		try {

			String searchText = mensaje + " wikipedia";
			Document google = Jsoup
					.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding))
					.userAgent("Mozilla/5.0").get();
			String wikipediaURL = google.getElementsByTag("cite").get(0).text();
			System.out.println(wikipediaURL);

			String wikipediaApiJSON = "https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
					+ URLEncoder.encode(
							wikipediaURL.substring(wikipediaURL.lastIndexOf("/") + 1, wikipediaURL.length()), encoding);

			System.out.println(wikipediaURL);

			HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
			httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
			String responseSB = in.lines().collect(Collectors.joining());
			in.close();

			String result = responseSB.split("extract\":\"")[1];

			textToTell = result.length() > 250 ? result.substring(0, 250) : result;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return textToTell;

	}

}