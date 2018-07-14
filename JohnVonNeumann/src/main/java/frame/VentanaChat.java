package frame;

import cliente.entidades.Usuario;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaChat extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NetworkManager net;
	DefaultListModel<String> mlu;
	DefaultListModel<String> salas;
	String user;

	public VentanaChat(servidor.Usuario u, String ip, Integer port) {

		net = NetworkManager.getInstance();
		net.setServer(ip, port);
		net.setInterfaz(this);
		net.enviar("NICK " + u.getNick());
		user = u.getNick();
		mlu = new DefaultListModel<>();
		salas = new DefaultListModel<>();
		initComponents();
		setComponentsExtras();

		new Thread(new Runnable() {
			@Override
			public void run() {
				net.escucharServidor();
			}
		}).start();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				net.enviar("EXIT");
			}
		});
	}

	public VentanaChat() {

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		fieldMsg = new javax.swing.JTextField();
		btEnviar = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		areaMensajes = new javax.swing.JTextPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		fieldMsg.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				fieldMsgKeyPressed(evt);
			}
		});

		btEnviar.setText("Enviar");
		btEnviar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btEnviarActionPerformed(evt);
			}
		});

		areaMensajes.setEditable(false);
		jScrollPane2.setViewportView(areaMensajes);

		jList1.setModel(mlu);
		jList1.setFixedCellHeight(20);
		jScrollPane3.setViewportView(jList1);

		JScrollPane scrollPane = new JScrollPane();

		JButton crearSalaBoton = new JButton("Crear Sala");
		crearSalaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				areaMensajes.setText("");
				net.enviar("/C " + leerSala());
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()

						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(crearSalaBoton, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
						.addComponent(fieldMsg, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btEnviar, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)

								.addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
								.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(crearSalaBoton)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(fieldMsg,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btEnviar))
						.addContainerGap()));

		JLabel lblUsuarios = new JLabel("USUARIOS");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		jScrollPane3.setColumnHeaderView(lblUsuarios);

		JList listaSalas = new JList();
		listaSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JList list = (JList) arg0.getSource();
				if (arg0.getClickCount() == 2) {
					int index = list.locationToIndex(arg0.getPoint());
					String sala = (String) list.getModel().getElementAt(index);
					areaMensajes.setText("");
					net.enviar("/J " + sala);
				}
			}
		});
		listaSalas.setModel(salas);
		listaSalas.setFixedCellHeight(20);
		scrollPane.setViewportView(listaSalas);

		JLabel lblSalas = new JLabel("SALAS");
		lblSalas.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblSalas);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btEnviarActionPerformed
		// Enviamos el mensaje al servidor
		net.enviar(fieldMsg.getText());
		// Limpiamos el campo de texto
		fieldMsg.setText("");
	}// GEN-LAST:event_btEnviarActionPerformed

	private void fieldMsgKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_fieldMsgKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			btEnviarActionPerformed(null);
		}
	}// GEN-LAST:event_fieldMsgKeyPressed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextPane areaMensajes;
	private javax.swing.JButton btEnviar;
	private javax.swing.JTextField fieldMsg;
	private javax.swing.JList jList1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	// End of variables declaration//GEN-END:variables

	public void agregarUsuario(Usuario u) {
		mlu.addElement(u.getNick());
	}

	public void agregarSala(String nombre) {
		salas.addElement(nombre);
	}

	public void agregarMensaje(String s) {

		Document doc = areaMensajes.getDocument();

		try {
			if (!areaMensajes.getText().equals("")) {
				if (s.matches(".*http(s)?://.*(.jpg|.jpeg|.png|.gif)")) {
					String usuario = s.split(" ")[0];
					String s2 = s.split("://")[1];
					ImageIcon ico = new ImageIcon(new URL("https://" + s2));
					Image image = ico.getImage();
					int new_width = 200;
					int new_height = (int) (new_width * ((double) ico.getIconHeight() / (double) ico.getIconWidth()));
					Image newimg = image.getScaledInstance(new_width, new_height, java.awt.Image.SCALE_DEFAULT);
					ico = new ImageIcon(newimg);
					doc.insertString(doc.getLength(), "\n" + usuario + " ", null);
					areaMensajes.insertIcon(ico);
				} else {
					if(s.contains("@"+user))
						notificacionTag(s.split(":")[0]);
					doc.insertString(doc.getLength(), "\n" + s, null);
				}
			} else 
				areaMensajes.setText(s);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void limpiarListado() {
		mlu.clear();
	}

	public void limpiarSalas() {
		salas.clear();
	}

	private void setComponentsExtras() {
		DefaultCaret caret = (DefaultCaret) areaMensajes.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		jList1.setFixedCellHeight(20);
		setLocationRelativeTo(null);
		fieldMsg.requestFocus();
	}

	private String leerSala() {
		return JOptionPane.showInputDialog(null, "Introduce el nombre de la nueva sala", "Sala");
	}
	
	private void notificacionTag(String s) {
		JOptionPane.showMessageDialog(null,"Cuchame capo, "+s+" te está buscando, dale bola.");
	}

}
