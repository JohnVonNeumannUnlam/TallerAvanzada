package bot;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Meme {

	public static String mostrarMeme(String nombreMeme) {// el asistente deberia llamar el metodo pasandome el nombre del
														// meme.

		HashMap<String, String> map = new HashMap<String, String>(); // Creo un hashmap donde la clave es el nombre del
																		// meme y el valor es la url del meme.
		map.put("Its a trap", "http://i0.kym-cdn.com/entries/icons/original/000/000/157/itsatrap.jpg");
		map.put("Take my money", "http://i0.kym-cdn.com/photos/images/newsfeed/000/264/200/acb.jpg");
		map.put("hide the pain",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3xStPS7GE_8wYxGoVDKR1BCSTFu-X6Bxs9Ha3u5gb8xBXxXn9Qw");
		map.put("wat", "http://i0.kym-cdn.com/photos/images/newsfeed/000/173/576/Wat8.jpg?1315930535");
		map.put("Bad luck brian", "http://i0.kym-cdn.com/entries/icons/mobile/000/009/515/BadLuckBryan.jpg");
		map.put("puta que oferton", "https://cdn.dopl3r.com/memes_files/puta-que-oferton-memegenes-b6H6t.jpg");
		map.put("khea", "https://pbs.twimg.com/media/DXiviVIW0AUcRE8.jpg");
		map.put("nigga cry",
				"https://4.bp.blogspot.com/-7Sak9jnYW2I/UJrUjN3ozPI/AAAAAAAAAYY/DKoeELbg-4o/s400/negro+llora.jpg");
		map.put("no lo se rick", "http://wikinoticias.mx/wp-content/uploads/2017/11/parece-falso-1.jpg");
		map.put("porque eres asi", "https://pbs.twimg.com/media/Cur7IWZWgAAVbrf.jpg");
		map.put("primitive sponge", "http://i0.kym-cdn.com/entries/icons/mobile/000/018/259/55181940.jpg");
		map.put("reaction guys",
				"http://i0.kym-cdn.com/photos/images/facebook/000/131/896/gaijin4koma2_peersblog_1200684608.jpg");
		map.put("no ahora por favor", "https://pm1.narvii.com/6198/2e2b4399e5067b59e732296ca3815ed717f3501e_hq.jpg");
		map.put("ponte verga",
				"https://vignette.wikia.nocookie.net/guikidanza/images/b/bd/Ponte_vergas.jpg/revision/latest?cb=20170429052018&path-prefix=es");
		map.put("atendedor",
				"https://vignette.wikia.nocookie.net/memes-pedia/images/c/c3/AtiendeBoludos.jpg/revision/latest?cb=20160227164018&path-prefix=es");
		map.put("ste men", "https://pm1.narvii.com/6264/0704a2819b6e6491c5f3f0598b5e6f5937076757_hq.jpg");
		
		String url = map.get(nombreMeme);
		return url;
		
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//						| UnsupportedLookAndFeelException ex) {
//				}
//
//				try {
//					URL url = new URL(map.get(nombreMeme));// agarro la url dependiendo que nombre del meme pasaron por
//															// parametro
//					BufferedImage image = ImageIO.read(url);
//					JLabel label = new JLabel(new ImageIcon(image));// esto es toda la gilada para poder mostrarlo. va a
//																	// depender de como es la interfaz.
//					JFrame f = new JFrame();
//					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					f.getContentPane().add(label);
//					f.pack();
//					f.setLocation(200, 200);
//					f.setVisible(true);
//				} catch (Exception exp) {
//					exp.printStackTrace();
//				}
//
//			}
//		});
	}

	public static void main(String[] args) {

		String url = Meme.mostrarMeme("ste men");
		System.out.println(url);
	}

}
