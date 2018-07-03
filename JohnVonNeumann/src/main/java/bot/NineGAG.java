package bot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NineGAG {

	public static String buscarGAG() {
		Document doc;
		String url = null;
		try {
			doc = Jsoup.connect("http://9gag.com/random").get();
			String title = doc.title();
			// System.out.println(title);
			Elements image = doc.getElementsByAttributeValue("property", "og:image");
			url = image.attr("content");
			// System.out.println(url);
//			mostrarGAG(title, url);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

//	public static void mostrarGAG(String title, String url) throws MalformedURLException {
//
//		URL urlImagen = new URL(url);
//		Icon icon = new ImageIcon(urlImagen);
//		JLabel label = new JLabel(icon);
//
//		JFrame f = new JFrame(title);
//		f.getContentPane().add(label);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.pack();
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
//
//	}

	public static void main(String[] args) throws MalformedURLException {
		String url = NineGAG.buscarGAG();
		System.out.println(url);
	}
}
