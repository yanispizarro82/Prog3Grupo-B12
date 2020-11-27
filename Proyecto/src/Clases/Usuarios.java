package Clases;

import java.util.*;

public class Usuarios {

	private String correo;
	private String password;
	private HashSet<Pedidos> pedidos;
	private ArrayList<Productos> cesta;
	private HashMap<String, ArrayList<Productos>> favoritos;

	public Usuarios(String correo, String password, HashSet<Pedidos> pedidos) {
		super();
		this.correo = correo;
		this.password = password;
		this.pedidos = pedidos;
		this.cesta = new ArrayList<Productos>();
		this.favoritos = new HashMap<String, ArrayList<Productos>>();
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

	public HashMap<String, ArrayList<Productos>> getFavoritos() {
		return favoritos;
	}

	public void setListas(HashMap<String, ArrayList<Productos>> favoritos) {
		this.favoritos = favoritos;
	}

	public ArrayList<Productos> getCesta() {
		return cesta;
	}

	public void setCesta(ArrayList<Productos> cesta) {
		this.cesta = cesta;
	}

	@Override
	public String toString() {
		return "Usuario: correo (" + correo + "), pedidos actuales: (" + pedidos + ")";
	}

	public void deleteUser() {
		
	}

}