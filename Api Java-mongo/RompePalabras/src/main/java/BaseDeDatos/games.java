package BaseDeDatos;

import org.bson.types.ObjectId;

public class games {
	private ObjectId Oid;
	private int game_id;
	private int winner;
	private int player1_id;
	private int player2_id;
	
	public games(){	
		
	}
	public games(int game_id, int winner, int player1_id, int player2_id) {
		this.setGame_id(game_id);
		this.setPlayer2_id(player2_id);
		this.setPlayer1_id(player1_id);
		this.setWinner(winner);
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

}
