package pl.AnotherTicTacToe.Models;

public class DefaultPlayerStatus implements IPlayerStatus {
	private String Name;
	private String Sign;
	
	public DefaultPlayerStatus(String name) {
		this.Name = name;
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
