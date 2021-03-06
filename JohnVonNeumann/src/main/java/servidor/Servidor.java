package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bot.Asistente;

public class Servidor {
    public static ArrayList<Sala> listadoSalas;
    public static final String ADMIN_PASSWORD = "admin";
    public static boolean saveLogs = true;

    public static void main(String[] args) throws IOException {
        
    	final int PORT = Integer.parseInt(Servidor.leerPuerto());
    	
    	if (saveLogs) System.out.println("Guardado de logs habilitado"); else System.out.println("Guardado de logs deshabilitado");
        
        //Creamos el socket para escuchar las conexiones entrantes
        ServerSocket ss = new ServerSocket(PORT);
        
        Log.log("Servidor inicializado en el puerto " + PORT);
        
        //Inicializamos el listado de salas, creamos la sala "Principal", que es
        //la sala por defecto y la agregamos al listado de salas
        listadoSalas = new ArrayList<>();
        Sala sala = new Sala("Principal");
        Asistente a = new Asistente("Robotitus");
        agregarSala(sala);
        
        //Bucle infinito que espera peticiones de conexión y crea instancias independientes para cada una
        while (true) {
            Socket socket = ss.accept();
            Log.log("Conexión establecida con " + socket.getInetAddress().getHostAddress());
            //Creamos una nueva instancia pasandole el socket y la sala principal
            new Thread(new Usuario(socket, sala)).start();
            
        }
    }
    
    public static void agregarSala(Sala s) {
        if (obtenerSala(s.getNombre()) == null) {
            listadoSalas.add(s);
            Log.log("Se ha creado la sala con nombre " + s.getNombre());
            for(Sala sa: listadoSalas) {
            	sa.difundirSalas();
            }
        }
    }
    
    public static void eliminarSala(Sala s) {
        if (obtenerSala(s.getNombre()) != null && !s.getNombre().equalsIgnoreCase("Principal")) {
            s.moverASala(listadoSalas.get(0));
            listadoSalas.remove(s);
            Log.log("Se ha eliminado la sala con nombre " + s.getNombre());
        }
    }
    
    public static Sala obtenerSala(String nombre) {
        for (Sala s : listadoSalas) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                return s;
            }
        }
        return null;
    }
    
    public static Sala[] obtenerSalas() {
        Sala[] s = new Sala[listadoSalas.size()];
        for (int i = 0; i < listadoSalas.size(); i++) {
            s[i] = listadoSalas.get(i);
        }
        return s;
    }
    
    public static boolean existeSala(Sala s) {
        for (int i = 0; i < listadoSalas.size(); i++) {
            if (listadoSalas.get(i).getNombre().equalsIgnoreCase(s.getNombre())) {
                return true;
            }
        }
        return false;
    }
    
    private static String leerPuerto() {
		return JOptionPane.showInputDialog(null, "Introduce el numero del puerto", "PORT");
	}

}
