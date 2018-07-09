package socket;

import java.util.ArrayList;

import frame.NetworkManager;

public class Sala {

	private ArrayList<Usuario> usuarios;
	private String nombre;
	private String password;
	
	
	public Sala(String nombre) {
		this.nombre = nombre;
		this.password = "";
		this.usuarios = new ArrayList<>();
	}

	public Sala(String nombre, String pw) {
		this.nombre = nombre;
		this.password = pw;
		this.usuarios = new ArrayList<>();
	}
	
	
	public String entrar(Usuario u) {
		if (!existeUsuario(u)) {
			u.setConectado(true);
			usuarios.add(u);
			difundir(u.getNombreUsuario() + " entro en la sala " + this.nombre + "!");
			actualizarListadoUsuarios();
			return "OK";
		} else {
			u.setConectado(false);
			return "El usuario ya existe en la sala";
		}
	}

	public boolean existeUsuario(Usuario u)
	{
		for(Usuario usr: usuarios) {
			if(usr.getNombreUsuario().equalsIgnoreCase(u.getNombreUsuario())){
				return true;
			}
		}
		return false;
	}
	
	public void salir(Usuario u) {
        //Si existe el usuario salimos de la sala
        if (existeUsuario(u)) {
            //Lo eliminamos de la lista de usuarios de la sala
            usuarios.remove(u);
            //Difundimos el mensaje de salida a todos los miembros de la sala
            difundir(u.getNombreUsuario() + " a salido de la sala " + this.nombre);
            //Enviamos el listado de usuarios actualizado a todos los usuarios de la sala
            actualizarListadoUsuarios();
            //Log.log(u.getNick() + " a salido de la sala " + this.nombre);
        }
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void difundir(String mensaje) {
		for (Usuario usr : usuarios) {
			usr.enviar(mensaje);
		}
	}

	public void actualizarListadoUsuarios() {
		for (Usuario usr : usuarios) {
			usr.enviarListaUsuarios();
		}
	}

	public int getCountUsuarios() {
		return usuarios.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
