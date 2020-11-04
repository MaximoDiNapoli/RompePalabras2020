package BaseDeDatos;

import java.util.ArrayList;
import java.util.Vector;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.sun.tools.javac.code.Attribute.Array;

@Entity
public class Usuarios {
	
	@Id
	private ObjectId Oid;
	private int id;
	private String username;
	Vector friends;
	private String email;
	private int elo;
	
	public Usuarios(){
        this.id = ultimoIDUsuario();  
        this.friends = new Vector(0);
        this.friends.addElement(1);
        this.username = "elpepe";
        this.email = "elpepe"; 
        this.elo = 1000; 
	}
	
	private int ultimoIDUsuario() {
		return BaseDeDatos.conexionMongoAtlas.ultimoIDUsuario();
	}

	public Usuarios(int id, String username, Vector friends, String email, int elo) {
		this.setId(id);
		this.setUsername(username);
		this.setFriends(friends);
		this.setEmail(email);
		this.setElo(elo);
		
	}

	public ObjectId getOId() {
		return Oid;
	}
	public void setOId(ObjectId Oid) {
		this.Oid = Oid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Vector getFriends() {
		return friends;
	}

	public void setFriends(Vector friends) {
		this.friends = friends;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}
	
}