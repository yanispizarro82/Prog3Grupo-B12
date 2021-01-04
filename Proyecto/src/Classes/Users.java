package Classes;

import java.util.*;

public class Users {

	private String mail;
	private String password;
	private HashSet<Order> orders;
	private ArrayList<Products> basket;
	private HashMap<String,ArrayList<Products>> list;
	private String correo;
	
	public Users(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	public Users(String mail, String password, HashSet<Order> orders) {
		super();
		this.mail = correo;
		this.password = password;
		this.orders = orders;
		this.basket = new ArrayList<Products>();
		this.list = new HashMap<String, ArrayList<Products>>();

	}

	public String getMail() {
		return mail;
	}

	public void setMail(String correo) {
		this.mail = correo;
	}

	public String getPassword() {
		return password;
	}

	public HashSet<Order> getOrders() {
		return orders;
	}

	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Products> getBasket() {
		return basket;
	}

	public void setBasket(ArrayList<Products> basket) {
		this.basket = basket;
	}
	
	public HashMap<String,ArrayList<Products>> getList() {
		return list;
	}

	public void setList(HashMap<String,ArrayList<Products>> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Usuario: correo (" + mail + "), pedidos actuales: (" + orders + ")";
	}
	
	public void addList(String name, Products first) {
		if(!this.list.containsKey(name)) {
			this.list.put(name, new ArrayList<Products>());
		}
		this.list.get(name).add(first);
	}
	
}