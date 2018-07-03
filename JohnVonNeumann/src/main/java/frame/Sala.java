package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import bot.Asistente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.awt.Dialog.ModalExclusionType;

public class Sala {
	
	
	JFrame salaFrame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sala window = new Sala();
					window.salaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sala() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		salaFrame = new JFrame();
		salaFrame.setBounds(200, 200, 1000, 800);
		salaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		salaFrame.getContentPane().setLayout(null);

		textField = new JTextField();

		textField.setBounds(284, 690, 686, 50);
		salaFrame.getContentPane().add(textField);
		textField.setColumns(10);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(284, 96, 686, 581);
				salaFrame.getContentPane().add(scrollPane_1);
		
				JTextPane textPane = new JTextPane();
				scrollPane_1.setViewportView(textPane);
				textPane.setEditable(false);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(12, 96, 232, 581);
						salaFrame.getContentPane().add(scrollPane);
				
						JList list = new JList();
						scrollPane.setViewportView(list);

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Asistente a = new Asistente("Bobo");
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if (textField.getText().contains("@" + a.getNombreAsistente())) {

						try {
							String respuesta = a.enviar("Maxi", textField.getText());
							if(textPane.getText().isEmpty()) {
								textPane.setText(textField.getText() + "\n" + respuesta);
							}else {
								textPane.setText(textPane.getText() + "\n" + textField.getText() + "\n" + respuesta);
							}
						if(respuesta.contains("http")) {
							URL url = new URL(respuesta);
							textPane.insertIcon(new ImageIcon(url));
												}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						if (textPane.getText().isEmpty()) {
							textPane.setText(textField.getText());
						} else {
							textPane.setText(textPane.getText() + "\n" + textField.getText());
						}
					}
					textField.setText("");
				}

			}

		});
	}
}
