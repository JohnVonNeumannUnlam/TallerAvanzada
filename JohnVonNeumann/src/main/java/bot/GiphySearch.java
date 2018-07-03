package bot;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

//	public static void mostrarGif(String URL) throws MalformedURLException {
//		URL url = new URL(URL);
//		Icon icon = new ImageIcon(url);
//		JLabel label = new JLabel(icon);
//
//		JFrame f = new JFrame("GIF");
//		f.getContentPane().add(label);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.pack();
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
//	}

	public static void main(String[] args) throws GiphyException, MalformedURLException {
		GiphySearch gs = new GiphySearch();
		String url = gs.buscarGIF("sasha gray");
//		gs.mostrarGif(url);
		System.out.println(url);
	}

}
