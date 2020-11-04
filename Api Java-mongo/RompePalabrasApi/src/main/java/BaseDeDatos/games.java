package BaseDeDatos;

import java.util.Vector;

import org.bson.types.ObjectId;

public class games {
	private ObjectId Oid;
	private int game_id;
	private int winner;
	private int player1_id;
	private int player2_id;
	private int puntajePlayer1;
	private int puntajePlayer2;
	
	
	public games(){
        this.game_id = ultimoIDGames();  
        this.player1_id = 0;
        this.player2_id = 0;
        this.puntajePlayer1 = 0; 
        this.puntajePlayer2 = 0; 
	}
	
	
	private int ultimoIDGames() {
		return BaseDeDatos.conexionMongoAtlas.ultimoIDGames();
	}


	public games(int game_id, int winner, int player1_id, int player2_id, int puntajePlayer1, int puntajePlayer2) {
		this.setGame_id(game_id);
		this.setPlayer2_id(player2_id);
		this.setPlayer1_id(player1_id);
		this.setWinner(winner);
		this.setPuntajePlayer1(puntajePlayer1);
		this.setPuntajePlayer2(puntajePlayer2);
		
		
	}

	public ObjectId getOid() {
		return Oid;
	}

	public void setOid(ObjectId oid) {
		Oid = oid;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public int getPlayer1_id() {
		return player1_id;
	}

	public void setPlayer1_id(int player1_id) {
		this.player1_id = player1_id;
	}

	public int getPlayer2_id() {
		return player2_id;
	}

	public void setPlayer2_id(int player2_id) {
		this.player2_id = player2_id;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getPuntajePlayer2() {
		return puntajePlayer2;
	}
	public void setPuntajePlayer2(int puntajePlayer2) {
		this.puntajePlayer2 = puntajePlayer2;
	}
	public int getPuntajePlayer1() {
		return puntajePlayer1;
	}
	public void setPuntajePlayer1(int puntajePlayer1) {
		this.puntajePlayer1 = puntajePlayer1;
	}

}
