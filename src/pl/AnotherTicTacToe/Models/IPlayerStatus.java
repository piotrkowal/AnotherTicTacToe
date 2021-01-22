package pl.AnotherTicTacToe.Models;

public interface IPlayerStatus {
	public void setCurrentPlayer(boolean isCurrent);
	public boolean getCurrentPlayer();
	public String GetPlayerName();
	public String GetPlayerSymbol();
}
