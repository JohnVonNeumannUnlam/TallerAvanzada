package bot;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
/* w w w  .ja  v  a2 s  .c o  m*/
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
public class PruebaTextPane {



	  public static void main(String args[]) throws Exception{
	    JFrame frame = new JFrame("TextPane Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    StyleContext context = new StyleContext();
	    StyledDocument document = new DefaultStyledDocument(context);

	    Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
	    
	    URL url = new URL("https://i.giphy.com/media/ai8vy8oZ6tkIM/giphy.gif");
	    BufferedImage image = ImageIO.read(url);
	    
	    Icon icon = new ImageIcon(image);
	    JLabel label = new JLabel(icon);
	    StyleConstants.setComponent(labelStyle, label);

	    try {
	      document.insertString(document.getLength(), "Ignored", labelStyle);
	    } catch (BadLocationException badLocationException) {
	      System.err.println("Oops");
	    }

	    JTextPane textPane = new JTextPane();
	    textPane.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textPane);
	    frame.add(scrollPane, BorderLayout.CENTER);

	    frame.setSize(400, 450);
	    frame.setVisible(true);
	  }
	
}
