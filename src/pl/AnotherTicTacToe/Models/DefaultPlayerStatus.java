package pl.AnotherTicTacToe.Models;

public class DefaultPlayerStatus implements IPlayerStatus {
	private String Name;
	private String Sign;
	public boolean isCurrentPlayer;
	public DefaultPlayerStatus(String name) {
		this.Name = name;
		this.Sign = "X";
		this.isCurrentPlayer = false;
	}
	
	public DefaultPlayerStatus(String name, String sign) {
		this.Name = name;
		this.Sign = sign;
		this.isCurrentPlayer = false;
	}
	
	@Override
	public String GetPlayerName() {
		// TODO Auto-generated method stub
		return this.Name;
	}

	@Override
	public String GetPlayerSymbol() {
		// TODO Auto-generated method stub
		return this.Sign;
	}

}
