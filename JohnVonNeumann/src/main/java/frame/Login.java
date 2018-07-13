package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bdd.*;
import java.awt.Font;

public class Login {

	JFrame frmChatbot;
	private JTextField usuarioTxtField;
	private JTextField passTxtField;
	private String usr; 

	/**	
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmChatbot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChatbot = new JFrame();
		frmChatbot.setTitle("ChatBot");
		frmChatbot.setBounds(100, 100, 450, 300);
		frmChatbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChatbot.getContentPane().setLayout(null);

		usuarioTxtField = new JTextField();
		usuarioTxtField.setBounds(140, 45, 170, 22);
		frmChatbot.getContentPane().add(usuarioTxtField);
		usuarioTxtField.setColumns(10);

		passTxtField = new JPasswordField();
		passTxtField.setBounds(140, 94, 170, 22);
		frmChatbot.getContentPane().add(passTxtField);
		passTxtField.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblUsuario.setBounds(43, 48, 85, 16);
		frmChatbot.getContentPane().add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblContrasea.setBounds(43, 97, 85, 16);
		frmChatbot.getContentPane().add(lblContrasea);

		JButton btnConectarse = new JButton("Conectarse");
		btnConectarse.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnConectarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usr = usuarioTxtField.getText();
				String pass = passTxtField.getText();
				Conector con = new Conector();
				con.connect();
				if (usuarioTxtField.getText().isEmpty() || passTxtField.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "ERROR - Empty fields",
							JOptionPane.ERROR_MESSAGE);
				else {
					if (con.mostrarUsuario(usr) == false) {

						JOptionPane.showMessageDialog(null,
								"Mira capo, me parece que no te conece nadie. Registrate y no me hagas perder mas el tiempo en esta consulta. Saludos y cuidate pa.",
								"Usuario inexistente", JOptionPane.ERROR_MESSAGE);
					} else if (con.mostrarUsuario(usr) && (con.mostrarPassword(pass) == false)) {

						JOptionPane.showMessageDialog(null, "La contrase�a no es valida", "Contrase�a incorrecta",
								JOptionPane.ERROR_MESSAGE);
					} else {
						
						servidor.Usuario usuario = new servidor.Usuario(usr);
						VentanaChat vc = new VentanaChat(usuario);
						vc.setVisible(true);
						
						frmChatbot.dispose();
					}
				}
				con.close();
			}

		});
		btnConectarse.setBounds(64, 162, 125, 36);
		frmChatbot.getContentPane().add(btnConectarse);

		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Registrarse reg = new Registrarse();
				reg.frmRegistro.setVisible(true);
				frmChatbot.dispose();

			}
		});
		btnNewButton.setBounds(213, 162, 148, 36);
		frmChatbot.getContentPane().add(btnNewButton);
	}
}
