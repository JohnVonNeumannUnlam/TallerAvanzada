package bot;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;

public class GiphySearch {

	private static String API_KEY = "dc6zaTOxFJmzC";

	public static String buscarGIF(String gif) throws GiphyException {

		Giphy g = new Giphy(API_KEY);
		SearchFeed fd = g.search(gif, 1, 0);

		String urlObtenida = fd.getDataList().get(0).getImages().getOriginal().getUrl();

		String gifID = urlObtenida.substring(31, 44);

		String urlFinal = "https://i.giphy.com/media/" + gifID + "/giphy.gif";

		return urlFinal;

	}

}
