package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario implements Runnable {

	private String nombreUsuario;
	private BufferedReader entrada;
	private BufferedWriter salida;
	// private long loginTime;
	private boolean conectado, superUser, heartBeatOn;
	private String IP;
	// private long ping;
	private Sala sala;

	public Usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Usuario(Socket s, Sala sala) throws IOException {
		this.sala = sala;
		// this.loginTime = System.currentTimeMillis();
		this.IP = s.getInetAddress().getHostAddress();
		// this.ping = 0;
		this.superUser = false;
		this.heartBeatOn = true;
		entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
		salida = new BufferedWriter(new PrintWriter(s.getOutputStream()));
	}

	@Override
	public void run() {
		// Espera a recibir el mensaje de login del cliente
		String login = recibir();
		 conectado = false;
		// Comprueba que el mensaje de login es correcto
		if (!login.contains("OK")) {
			// //Desconecta el cliente si hay un error
			// enviar("400 Paquete inválido recibido");
			// Log.log("Paquete de login inválido: " + login);
			// conectado = false;
		} else {
			// //Comprueba que el tamaño del nick no sea muy largo
			// if (login.split("[ ]")[1].length() >= 12) {
			// //Envia un error y desconecta al usuario
			// enviar("400 El nick elegido es demasiado largo, introduce un nick de como
			// máximo 12 carácteres");
			// Log.log("Un usuario ha tratado de entrar con un nick demasiado largo. Nick: "
			// + login.split("[ ]")[1]);
			// } else {
			// Conecta al cliente si el usuario no existe en la sala
			conectado = true;
		}

		// Si todo esta correcto se conecta a la sala
		if (conectado) {
			// Obtenemos el nick recibido del cliente
			// nick = login.split("[ ]")[1];

			// Conectamos al usuario a la sala
			enviar(sala.entrar(this));
			// Enviamos la lista de usuarios de la sala
			enviarListaUsuarios();

			// if (heartBeatOn) {
			// //Inicializamos el heartbeat para comprobar que el cliente mantiene la
			// conexión
			// lastBeat = System.currentTimeMillis();
			// asyncBeatCheck();
			// }
			// Enviamos el nombre de la sala
			enviar("SALA " + sala.getNombre());

			// Bucle que durará hasta que el usuario se desconecte (EXIT o errores)
			do {
				// Esperamos a recibir un mensaje del cliente
				String packet = recibir();

				// Si el paquete no está vacio lo analizamos
				if (packet != null && !packet.isEmpty()) {
					analizarPacket(packet);
				}

			} while (conectado);

			// Enviamos el mensaje de desconexion al usuario
			enviar("Has sido desconectado del chat");

			// El cliente ya no está conectado, lo sacamos de la sala
			sala.salir(this);
		}
	}
	
	public void analizarPacket(String s) {
		if(s.contains("EXIT")) {
			conectado = false;
		}
		else {
			sala.difundir(nombreUsuario + ": " + s);
		}
	}
	
	 public void enviarListaUsuarios() {
	        StringBuilder strb = new StringBuilder();
	        strb.append("LIST ");
	        for (Usuario usr : sala.getUsuarios()) {
	            strb.append(usr.getNombreUsuario());
	            strb.append(" ");
	        }
	        enviar(strb.toString());
	    }
	    
	    public void enviar(String s) {
	        try {
	            salida.write(s + "\n");
	            salida.flush();
	        } catch (IOException ex) {
	            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public String recibir() {
	        String s = "";
	        try {
	            s = entrada.readLine();
	        } catch (Exception ex) {}
	        return s;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public BufferedReader getEntrada() {
		return entrada;
	}

	public void setEntrada(BufferedReader entrada) {
		this.entrada = entrada;
	}

	public BufferedWriter getSalida() {
		return salida;
	}

	public void setSalida(BufferedWriter salida) {
		this.salida = salida;
	}

	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	public boolean isSuperUser() {
		return superUser;
	}

	public void setSuperUser(boolean superUser) {
		this.superUser = superUser;
	}

	public boolean isHeartBeatOn() {
		return heartBeatOn;
	}

	public void setHeartBeatOn(boolean heartBeatOn) {
		this.heartBeatOn = heartBeatOn;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}
