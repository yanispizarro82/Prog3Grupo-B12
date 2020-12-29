package Clases;

import java.util.*;

public class Usuarios {

	private String correo;
	private String password;
	private HashSet<Pedidos> pedidos;
	private ArrayList<Productos> cesta;
	private HashMap<String,ArrayList<Productos>> lista;
	
	public Usuarios(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}

	public Usuarios(String correo, String password, HashSet<Pedidos> pedidos) {
		super();
		this.correo = correo;
		this.password = password;
		this.pedidos = pedidos;
		this.cesta = new ArrayList<Productos>();
		this.lista = new HashMap<String, ArrayList<Productos>>();

	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public HashSet<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(HashSet<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Productos> getCesta() {
		return cesta;
	}

	public void setCesta(ArrayList<Productos> cesta) {
		this.cesta = cesta;
	}
	
	public HashMap<String,ArrayList<Productos>> getListas() {
		return lista;
	}

	public void setListas(HashMap<String,ArrayList<Productos>> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Usuario: correo (" + correo + "), pedidos actuales: (" + pedidos + ")";
	}
	
	public void anyadirALista(String nombre, Productos primero) {
		if(!this.lista.containsKey(nombre)) {
			this.lista.put(nombre, new ArrayList<Productos>());
		}
		this.lista.get(nombre).add(primero);
	}
	
}