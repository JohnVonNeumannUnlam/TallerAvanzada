package bot;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NineGAG {

	public static String buscarGAG() {
		Document doc;
		String url = null;
		try {
			doc = Jsoup.connect("http://9gag.com/random").get();
			Elements image = doc.getElementsByAttributeValue("property", "og:image");
			url = image.attr("content");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

	public static void main(String[] args) throws MalformedURLException {
		String url = NineGAG.buscarGAG();
		System.out.println(url);
	}
}
