package BaseDeDatos;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Usuarios {
	
	@Id
	private ObjectId Oid;
	private int id;
	private String username;
	private int[] friends;
	private String email;
	private int elo;
	
	public Usuarios(){
        this.id = 4; 
        this.username = "elpepe";
        this.email = "elpepe"; 
        this.elo = 0; 
	}
	
	public Usuarios(int id, String username, int[] friends, String email, int elo) {
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

	public int[] getFriends() {
		return friends;
	}

	public void setFriends(int[] friends) {
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